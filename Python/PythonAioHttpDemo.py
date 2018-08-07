import time
import asyncio
from aiohttp import ClientSession, TCPConnector, BasicAuth

async def fetch(url, session):
    proxy_auth = BasicAuth('ud92tos25', 'usgggs25')
    async with session.get(url=url,
                           proxy="http://http-proxy-sg2.dobel.cn:9180",
                           proxy_auth=proxy_auth) as resp:
        print(await resp.read())

connector = TCPConnector(limit=20)
session = ClientSession(connector=connector)
nums = 100
url = 'http://www.taobao.com/help/getip.php'
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

