package com.hspm.ojt.domain.service.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hspm.ojt.domain.ShippingAddress;
import com.hspm.ojt.repository.ShippingAddressRepository;
import com.hspm.ojt.service.ShippingAddressService;

@Service
public class ShippingAddressImpl implements ShippingAddressService{
	private final ShippingAddressRepository shippingAddressRepo;
	
	

	public ShippingAddressImpl(ShippingAddressRepository shippingAddressRepo) {
		super();
		this.shippingAddressRepo = shippingAddressRepo;
	}

	@Override
	public ShippingAddress saveOrUpdate(ShippingAddress shippingAddress) {
		
//		Optional<ShippingAddress> shippingOpt = shippingAddressRepo.findById(shippingAddress.getShippingAddressId());
//		if(shippingOpt.isPresent()) {
//			shippingAddress.setShippingAddressId(shippingOpt.get().getShippingAddressId());
//		}
		
		
		return shippingAddressRepo.save(shippingAddress);
	}

	@Override
	public List<ShippingAddress> findAll() {
		
		return (List <ShippingAddress>) shippingAddressRepo.findAll();
	}

	@Override
	public Optional<ShippingAddress> findShippingAddressById(Long id) {
		
		return shippingAddressRepo.findById(id);
	}

	@Override
	public void deleteByShippingAddressId(Long id) {
		shippingAddressRepo.deleteById(id);
		
	}

}
