package com.rain.gameCommunity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rain.gameCommunity.dao.SectionDAO;
import com.rain.gameCommunity.entity.SectionEntity;
import com.rain.gameCommunity.entity.UserEntity;
import com.rain.gameCommunity.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	private SectionDAO sectionDao;
	@Autowired
	private UserServiceImpl userServiceImpl;
	

	public List<SectionEntity> showAllSection() throws Exception {

		List<SectionEntity> sections = sectionDao.queryAllSections();
		sections = changeManagerToString(sections);
		return sections;
	}
	
	private List<SectionEntity> changeManagerToString(List<SectionEntity> sections) throws Exception{
		
		for(SectionEntity section : sections){
			String sectionManager = section.getSectionManager();
			String[] managersString = sectionManager.split(",");
			List<Long> managers = new ArrayList<Long>();
			for(int i = 0; i < managersString.length; i++){
				managers.add(Long.parseLong(managersString[i]));
			}
			section.setSectionManager("");
			List<UserEntity> users = userServiceImpl.queryUsersById(managers);
			for(UserEntity user : users){
				section.setSectionManager(section.getSectionManager() + user.getUsername() + ",");
			}
			section.setSectionManager(section.getSectionManager().substring(0, section.getSectionManager().length() - 1));
		}
		return sections;
	}

	@Override
	public List<SectionEntity> showSectionsByGameTypeId(long id) throws Exception {
		List<SectionEntity> sections = sectionDao.querySectionsByGameTypeId(id);
		sections = changeManagerToString(sections);
		return sections;
	}

	@Override
	public List<SectionEntity> showSectionsBySectionId(String id) throws Exception {
		List<Long> ids = new ArrayList<Long>();
		String[] idsString = id.split(",");
		for(int i = 0; i < idsString.length; i++){
			ids.add(Long.parseLong(idsString[i]));
		}
		List<SectionEntity> sections = sectionDao.querySectionsBySectionId(ids);
		sections = changeManagerToString(sections);
		return sections;
	}

	@Override
	public int showSectionsCountBySectionId(long id) throws Exception {
		return sectionDao.querySectionsCountByGameTypeId(id);
	}

}
