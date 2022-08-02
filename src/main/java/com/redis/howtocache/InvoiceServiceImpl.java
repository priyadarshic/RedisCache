package com.redis.howtocache;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Override
    @CachePut(value="Invoice", key="#inv")
    public Invoice saveInvoice(Invoice inv) {

//        return invoiceRepo.save(inv);
        return invoiceRepo.saveAndFlush(inv);
    }

    @Override
    @CachePut(value="Invoice", key="#invId")
    public Invoice updateInvoice(Invoice inv, Integer invId) {
        Invoice invoice = invoiceRepo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoice.setInvAmount(inv.getInvAmount());
        invoice.setInvName(inv.getInvName());
        return invoiceRepo.save(invoice);
    }

    @Override
//    @CacheEvict(value="Invoice", key="#invId")
    @CacheEvict(value="Invoice", allEntries=true) //in case there are multiple entires to delete
    public void deleteInvoice(Integer invId) {
        Invoice invoice = invoiceRepo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoiceRepo.delete(invoice);
    }

    @SneakyThrows
    @Override
    @Cacheable(value="Invoice", key="#invId")
    public Invoice getOneInvoice(Integer invId) {
        Thread.sleep(4*1000);   //Delay to test Caching performance
        Invoice invoice = invoiceRepo.findById(invId)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        return invoice;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }
}