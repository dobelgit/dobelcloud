import time
import asyncio
from aiohttp import ClientSession, TCPConnector, BasicAuth

async def fetch(url, session):
    proxy_auth = BasicAuth('账号', '密码')
    headers = {'connection': 'closed'}
    async with session.get(url=url,
                           proxy="http://域名:端口",
                           proxy_auth=proxy_auth,
                           headers=headers) as resp:
        print(await resp.read())

connector = TCPConnector(limit=10)
session = ClientSession(connector=connector)
nums = 300
url = 'https://pv.sohu.com/cityjson?ie=utf-8'
tasks = [fetch(url, session) for x in range(nums)]
begin = time.time()
try:
        loop = asyncio.get_event_loop()
        loop.run_until_complete(asyncio.wait(tasks))
except:
        pass
finally:
        end = time.time()
        loop.close()
        session.close()
        print('cost', end - begin, 'speed', nums / (end - begin), 'req/s')
