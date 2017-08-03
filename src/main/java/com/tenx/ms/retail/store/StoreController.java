package com.tenx.ms.retail.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @RequestMapping("/store/all")
    public List<Store> getAllStores(){
        return storeService.getAllStores();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/store/detail/{store_id}")
    public Store getStoreDetail(@PathVariable("store_id") int store_id){
        return storeService.getStoreDetail(store_id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/store/add")
    public ResponseEntity<Store> addStore(@RequestBody Store store){
        return new ResponseEntity<Store>(storeService.addStore(store), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/store/update/{store_id}")
    public void updateStore(@PathVariable("store_id") int store_id, @RequestBody Store store){
        storeService.updateStore(store_id, store);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/store/delete/{store_id}")
    public void deteleStore(@PathVariable int store_id){
        storeService.deleteStore(store_id);
    }
}
