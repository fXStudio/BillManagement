package com.freeway.web.controllers.business;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freeway.web.helper.IPHelper;
import com.freeway.web.models.SystemUser;
import com.freeway.web.protocal.ConditionFiled;
import com.freeway.web.services.business.ICardSearchService;

/**
 * 坏卡
 *
 * @author Ajaxfan
 */
@RestController
@RequestMapping(value = "services", method = RequestMethod.POST)
public class BadCardSearchController {
	private @Autowired ICardSearchService cardSearchService;

	/**
	 * 坏卡
	 *
	 * @param limit
	 *            开始索引
	 * @param start
	 *            结束索引
	 * @return
	 */
	@RequestMapping(value = "cardList")
	public Object badCardList(ConditionFiled cf, HttpServletRequest request) {
		SystemUser user = (SystemUser) request.getSession().getAttribute("freeWayUser");
		cf.setIp(IPHelper.getIPAddress(request));
		cf.setLoginUser(user.getSysid());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", cardSearchService.getSize(cf));// 记录总数
		map.put("items", cardSearchService.findRecords(cf));// 记录行对象

		return map;
	}
}
