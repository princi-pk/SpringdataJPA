package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@SpringBootApplication
public class OrmLearnApplication {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	@Autowired
	static StockRepository stockRepository;
	
	
	private static void getFbSep2019Test() {
		LOGGER.info("Start");
		List<Stock> stockList = stockRepository.findByCodeAndDateLike("FB","2019-9%");
		LOGGER.debug("stockList={}", stockList);
		LOGGER.info("End");
	}
	
	private static void getGoogl1250Test() {
		LOGGER.info("Start");
		List<Stock> stockList = stockRepository.findByCodeAndOpenGreaterThanAndCloseGreaterThan("GOOGL", BigDecimal.valueOf(1250), BigDecimal.valueOf(1250));
		LOGGER.debug("stockList={}", stockList);
		LOGGER.info("End");
	}
	
	private static void getTop3VolumeTest() {
		LOGGER.info("Start");
		List<Stock> stockList = stockRepository.findTop3ByOrderByVolumeDesc();
		LOGGER.debug("stockList={}", stockList);
		LOGGER.info("End");
	}
	
	private static void getLeast3NflxTest() {
		LOGGER.info("Start");
		List<Stock> stockList = stockRepository.findTop3ByCodeOrderByClose("NFLX");
		LOGGER.debug("stockList={}", stockList);
		LOGGER.info("End");
	}
	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);			
		getFbSep2019Test();
		getGoogl1250Test();
		getTop3VolumeTest();
		getLeast3NflxTest();
	}

}
