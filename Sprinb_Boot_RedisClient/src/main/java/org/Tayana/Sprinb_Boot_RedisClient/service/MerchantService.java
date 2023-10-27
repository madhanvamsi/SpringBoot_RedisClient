package org.Tayana.Sprinb_Boot_RedisClient.service;

import java.util.List;

import org.Tayana.Sprinb_Boot_RedisClient.dao.MerchantDao;
import org.Tayana.Sprinb_Boot_RedisClient.dto.Merchant;
import org.Tayana.Sprinb_Boot_RedisClient.dto.ResponseStructure;
import org.Tayana.Sprinb_Boot_RedisClient.exception.IdNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService 
{

	
	@Autowired
	 private MerchantDao mdao;
	
	public ResponseEntity<ResponseStructure<Merchant>> save(Merchant merchant)
	{
		ResponseStructure<Merchant> structure=new ResponseStructure<Merchant>();
		structure.setData(mdao.saveMerchant(merchant));
		structure.setMessage("saved successfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
	}
	

	public ResponseEntity<ResponseStructure<List<Object>>> findAll()
	{
		ResponseStructure< List<Object>> structure=new ResponseStructure<List<Object>>();
		structure.setData(mdao.findAll());
		structure.setMessage("saved successfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<List<Object>>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Boolean>> findById(int id)
	{
		ResponseStructure<Boolean> structure=new ResponseStructure<Boolean>();
		boolean m=mdao.FindById(id);
		if(m)
		{
			structure.setData(m);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Merchant find ");
			return new ResponseEntity<ResponseStructure<Boolean>>(structure, HttpStatus.OK);
		}
		else
		{
		throw new IdNotFound();
		}
	}
	
	
}
