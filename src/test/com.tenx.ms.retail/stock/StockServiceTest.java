package stock;

import com.tenx.ms.retail.stock.Stock;
import com.tenx.ms.retail.stock.StockMapping;
import com.tenx.ms.retail.stock.StockRepository;
import com.tenx.ms.retail.stock.StockService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class StockServiceTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUpdateStock(){
        Stock stockList = new Stock(new StockMapping(5, 5), 10);
        when(stockRepository.save(any(Stock.class))).thenReturn(stockList);

        StockMapping stockMappingResult = stockService.updateStock(stockList.getStockMapping().getProductId(), stockList.getStockMapping().getStoreId(), new Stock(10));
        assertEquals(10, stockList.getCount());
    }

}
