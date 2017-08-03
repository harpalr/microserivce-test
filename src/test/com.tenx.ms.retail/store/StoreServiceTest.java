package com.tenx.ms.retail.store;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import com.tenx.ms.retail.store.StoreRepository;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StoreServiceTest {
    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private StoreService storeService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetAllStores(){

        List<Store> storesList = new ArrayList<Store>();
        storesList.add(new Store("HP", true));
        storesList.add(new Store("DELL", true));

        when(storeRepository.findAll()).thenReturn(storesList);
        List<Store> result = storeService.getAllStores();
        assertEquals(8, result.size());
    }

    @Test
    public void testGetStoreDetail(){
        Store store = new Store("HP", true);
        when(storeRepository.findOne(1)).thenReturn(store);
        Store result = storeService.getStoreDetail(1);
        assertEquals("HP", result.getStore_name());
    }

    @Test
    public void testAddStore(){
        Store store = new Store("HP", true);
        when(storeRepository.save(store)).thenReturn(store);
        Store result = storeService.addStore(store);
        assertEquals("HP", result.getStore_name());
    }

    @Test
    public void testDeleteStore(){
        Store store = new Store("HP", true);
        storeService.deleteStore(1);
        verify(storeRepository, times(1)).delete(1);
    }
}
