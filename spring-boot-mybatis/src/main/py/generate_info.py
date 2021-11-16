import collections
from datetime import *
from random import choice, randint

from faker import Faker


class FakeUsers:

    def __init__(self, lan = 'en_US'):
        self.lan = lan
        self.fake = Faker(lan)
        self.platform_list = ['bili', 'ios', 'huawei', 'oppo', 'vivo', 'xiaomi', '4399',
                'one plus', '应用宝', '网易yofun', '网易mumu', '努比亚', '魅族']

    def get_name(self, n = 1, first_name = True, last_name = True):
        """
        generate given number of unique first name
        """
        if first_name and last_name:
            if n == 1:
                return self.fake.name();
            else:
                names = set(self.fake.unique.name() for _ in range(n))
                return names
        elif first_name:
            if n == 1:
                return self.fake.first_name();
            else:
                names = set(self.fake.unique.first_name() for _ in range(n))
                return names
        else:
            if n == 1:
                return self.fake.last_name();
            else:
                names = set(self.fake.unique.last_name() for _ in range(n))
                return names

    def get_uid(self, n = 1, time = "-5y"):

        """
        generate given number of uid, uid format: date + time + random 10 digit
        param:
            n: number of uid to generate
            time: datetime to generate uid, dafault to '-5y', which means past five years
        """
        if n == 1:
            prefix = self.fake.past_datetime(time).strftime('%Y%m%d%H%M%S')
            suffix = "{:0>10}".format(''.join(str(choice(range(10))) for _ in range(choice(range(5,10)))))
            return prefix + suffix

        prefixes = set(self.fake.unique.past_datetime(time).strftime('%Y%m%d%H%M%S') for _ in range(n))
        uid = []
        for prefix in prefixes:
            suffix = "{:0>10}".format(''.join(str(choice(range(10))) for _ in range(choice(range(5,10)))))
            uid.append(prefix + suffix)

        return uid

    def get_level(self, n = 1, min = 0, max = 120, unique = False):
        '''
        generate given number of levels, include the endpoint
        '''
        if n == 1:
            return randint(min, max)
        if unique:
            return set(self.fake.unique.random_int(min, max) for _ in range(n))
        return [self.fake.random_int(min, max) for _ in range(n)]

    def get_age(self, n =1, min = 1, max = 100, unique = False):
        '''
        generate given number of ages, include the endpoint
        '''
        return self.get_level(n, min, max, unique)

    def get_platform(self, n = 1, platform_list = None):
        if platform_list == None:
            platform_list = self.platform_list

        if n == 1:
            return self.fake.random_element(elements = platform_list)
        return self.fake.random_elements(elements = platform_list, length = n)

    def get_ctime(self, n = 1, start = '-5y', end = 'now', unique = False):

        if n ==1 :
            return self.fake.date_time_between_dates(start, end)
        if unique:
            return set(self.fake.unique.date_time_between_dates(start, end) for _ in range(n))
        return [self.fake.unique.date_time_between_dates(start, end) for _ in range(n)];

    def get_ctime_and_mtime(self, n = 1, start = '-5y', end = 'now', mend = 'now', unique = False):
        '''
        mtime will after ctime
        param:
            start: satrt of ctime
            end: end of ctime
            mend: end of mtime, must after end
        '''
        if n ==1 :
            ctime = self.fake.date_time_between_dates(start, end)
            mtime = self.fake.date_time_between_dates(ctime, mend)
            return (ctime, mtime)
        if unique:
            ctimes = set(self.fake.unique.date_time_between_dates(start, end) for _ in range(n))
            return set((ctime, self.fake.date_time_between_dates(ctime, mend)) for ctime in ctimes)

        ctimes = [self.fake.unique.date_time_between_dates(start, end) for _ in range(n)]
        return [(ctime, self.fake.unique.date_time_between_dates(ctime, mend)) for ctime in ctimes];

    def get_format_ctime(self, n = 1, format = '%Y-%m-%d %H:%M:%S', start = '-5y', end = 'now', unique = False):
        '''
        generate string type ctime with specified format
        param:
            format: format of string, default style '2021-09-10 21:30:13'
        '''
        ctimes = self.get_ctime(n, start, end, unique)
        if n == 1:
            return ctimes.strftime(format)

        return [ctime.strftime(format) for ctime in ctimes]

    def get_format_ctime_and_mtime(self, n = 1, format = '%Y-%m-%d %H:%M:%S', start = '-5y', end = 'now', mend = 'now', unique = False):
        '''
        generate string type ctime with specified format
        param:
            format: format of string, default style '2021-09-10 21:30:13'
        '''
        # ctimes = self.get_ctime(n, start, end, unique)
        # if type(ctimes) == datetime:
        #     return ctimes.strftime(format)

        # return [ctime.strftime(format) for ctime in ctimes]

        times = self.get_ctime_and_mtime(n, start, end, mend, unique)

        if n ==1 :
            return (times[0].strftime(format), times[1].strftime(format))
        return [(time[0].strftime(format), time[1].strftime(format)) for time in times];

    def get_users(self, n=1, id=False, uid=True, name=True, auth_level=True, game_platform=True, ctime=False, mtime=False):

        if n == 1:
            return (self.get_uid(), self.get_name(), self.get_level(), self.get_platform())

        names = list(self.get_name(n))
        uids = list(self.get_uid(n))
        levels = list(self.get_level(n))
        platforms = self.get_platform(n)

        if ctime and mtime:
            times = self.get_ctime_and_mtime(n)
            User = collections.namedtuple('user', ['name', 'uid', 'level', 'platform', 'ctime', 'mtime'])
            return [User(names[i], uids[i], levels[i], platforms[i], times[i][0], times[i][1]) for i in range(n)]

        User = collections.namedtuple('user', ['name', 'uid', 'auth_level', 'game_platform'])
        return [User(names[i], uids[i], levels[i], platforms[i]) for i in range(n)]






