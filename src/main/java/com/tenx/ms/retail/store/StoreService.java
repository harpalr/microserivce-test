package com.tenx.ms.retail.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllStores(){
        List<Store> stores = new ArrayList<>();
        storeRepository.findAll().forEach(stores::add);
        return stores;
    }

    public Store getStoreDetail(int store_id){
        Store storeDetail;
        storeDetail = storeRepository.findOne(store_id);
        return storeDetail;
    }

    public Store addStore(Store store){
        return storeRepository.save(store);
    }

    public void updateStore(int store_id, Store store){
        store.setStore_id(store_id);
        storeRepository.save(store);
    }

    public void deleteStore(int store_id){
        storeRepository.delete(store_id);
    }
}
