# encoding: utf-8
from scrapy.spider import BaseSpider
from scrapy.selector import HtmlXPathSelector

class iqiyiSpider(BaseSpider):
	start_urls = ['http://top.iqiyi.com/dianying.html']
	name = 'iqiyiSpider'

	def parse(self,response):
		hxs = HtmlXPathSelector(response)
		#xs = hxs.select('//*[@id="tab_top50"]/div[1]/ul')
		xs = hxs.select('//ul[@class=\"tv_list\"]/li')
		for x in xs:
			#print x
			moviename = x.select('a[@class=\"topic\"]/@title').extract()[0]
			print moviename
			movieurl = x.select('a[@class=\"topic\"]/@href').extract()[0]
			print movieurl


		print "~~~~~~~~~~~~~~"
		#print xs.extract()
