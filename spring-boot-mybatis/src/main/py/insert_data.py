import json

import pymysql
import requests

import generate_info


class MysqlMybatis:

    def __init__(self, host='localhost', username='root', password='123456', db='test'):
        self.host = host
        self.username = username
        self.password = password
        self.db = db
        self.connection = pymysql.connect(
            host = host,
            user=username,
            password=password,
            db=db)

        self.faker = generate.FakeUsers()

    def insert_users(self, n = 1):

        cursor = self.connection.cursor()
        sql = "INSERT INTO `User` (`name`, `uid`, `auth_level`, `game_platform`, `ctime`, `mtime`)" + \
                "VALUES (%s, %s, %s, %s, %s, %s)"
        val = self.faker.get_users(n = n, ctime=True, mtime=True)

        try:
            cursor.executemany(sql, val)
            self.connection.commit()
            print("insert successfully")
        except:
            print("failed")
            self.connection.rollback()
        finally:
            self.connection.close()


class HttpMybatis:

    def __init__(self, host, port, base_path):
        self.host = host
        self.port = port
        self.base_path = base_path
        self.base_url = 'http://{}:{}{}'.format(host, port, base_path)
        self.faker = generate.FakeUsers()


    def getAll(self, path = "/", params={}):

        url = self.base_url + path
        return requests.get(url = url, params = params)

    def save_users(self, path = "/"):
        users = self.faker.get_users(2)
        url = self.base_url + path
        headers = {'Content-Type': 'application/json'}

        for user in users:
            resp = requests.post(url = url, data = json.dumps(user._asdict()), headers=headers)
            print(resp.status_code)



http_client = HttpMybatis('localhost', 8081, '/user')

http_client.save_users("/save")


resp = http_client.getAll("/get")
# print(resp.json())
for user in resp.json():
    print(user)
