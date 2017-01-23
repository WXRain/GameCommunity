package com.rain.gameCommunity.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rain.gameCommunity.entity.SectionEntity;

@Repository
public interface SectionService {

	public List<SectionEntity> showAllSection() throws Exception;
}
