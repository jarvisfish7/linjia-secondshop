package com.linjia.secondshop.services;

import com.linjia.secondshop.mappers.GoodMapper;
import com.linjia.secondshop.models.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodService {
	@Autowired
	private GoodMapper goodMapper;

	//获取全部商品，分页
	@Transactional
	public List<Good> getAllGoods(int offset, int limit) {
		return goodMapper.getAllGoods(offset, limit);
	}

	//获取全部商品
	@Transactional
	public List<Good> getAllGoodList() {
		return goodMapper.getAllGoodList();
	}

	//通过搜索框的信息获取
	@Transactional
	public List<Good> getGoodsBySearchAndType(String searchText,
			Integer secondTypeId, int offset, int limit) {
		if (!searchText.equals("")) {
			searchText = "%" + searchText + "%";
			return goodMapper.getGoodsBySearch(searchText, offset, limit);
		} else if (secondTypeId != null) {
			return goodMapper.getGoodsByType(secondTypeId, offset, limit);
		} else {
			return goodMapper.getAllGoods(offset, limit);
		}
	}

	//通过类型和搜索框获取
	@Transactional
	public int getGoodsBySearchAndTypeCount(String searchText,
			Integer secondTypeId) {
		if (!searchText.equals("")) {
			searchText = "%" + searchText + "%";
			return goodMapper.getGoodsBySearchCount(searchText);
		} else if (secondTypeId != null) {
			return goodMapper.getGoodsByTypeCount(secondTypeId);
		} else {
			return goodMapper.getAllGoodsCount();
		}
	}

	@Transactional
	public Good getGoodById(int goodId) {
		return goodMapper.getGoodById(goodId);
	}

	@Transactional
	public List<Good> getRECGoods(int secondTypeId, int goodId) {
		return goodMapper.getRECGoods(secondTypeId, goodId);
	}

	@Transactional
	public List<Good> getGoodByUserId(Integer userId) {
		return goodMapper.getGoodByUserId(userId);
	}

	@Transactional
	public List<Good> getGoodStatusByUserId(Integer userId) {
		return goodMapper.getGoodStatusByUserId(userId);
	}

	@Transactional
	public int insertGood(Good good) {
		return goodMapper.insterGood(good);
	}

	@Transactional
	public int updateGoodPhotoUrl(String photoUrl, Integer goodId) {
		return goodMapper.updateGoodPhotoUrl(photoUrl, goodId);
	}

	@Transactional
	public int updateGoodStatusId(Integer statusId, Integer goodId) {
		return goodMapper.updateGoodStatusId(statusId, goodId);
	}

	@Transactional
	public int updateGood(Good good) {
		return goodMapper.updateGood(good);
	}

	@Transactional
	public String getPhotoUrlByGoodId(Integer goodId) {
		return goodMapper.getPhotoUrlByGoodId(goodId);
	}

	@Transactional
	public int deleteGood(Integer goodId) {
		return goodMapper.deleteGood(goodId);
	}

	@Transactional
	public List<Good> getGoodsAdminByType(Integer secondTypeId) {
		return goodMapper.getGoodsAdminByTypeId(secondTypeId);
	}
}
