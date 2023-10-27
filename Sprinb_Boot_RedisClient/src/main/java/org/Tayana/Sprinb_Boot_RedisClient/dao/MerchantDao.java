package org.Tayana.Sprinb_Boot_RedisClient.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.Tayana.Sprinb_Boot_RedisClient.dto.Merchant;
import org.Tayana.Sprinb_Boot_RedisClient.repository.MercRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class MerchantDao 
{
	@Autowired
	private MercRepository repository;
	
	@Autowired
	private RedisTemplate<String, Object> template;
	
	public static final String KEY="merchant";
	//save method
	public Merchant saveMerchant(Merchant merchant)
	{
		template.opsForHash().put("merchant", merchant.getId(), merchant.toString());
		repository.save(merchant);
		return merchant;
	}
	public boolean FindById(int id)
	{
		
		template.opsForHash().get("merchant", id);
		repository.findById(id);
		return true;
	}
	
	public List<Object> findAll()
	{
		return  template.opsForHash().values(KEY);
		
		
	}
		
	
	
	
	
}
