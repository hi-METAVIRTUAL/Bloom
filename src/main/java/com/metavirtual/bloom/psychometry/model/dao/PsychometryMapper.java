package com.metavirtual.bloom.psychometry.model.dao;

import com.metavirtual.bloom.psychometry.model.dto.TestQDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Mapper
public interface PsychometryMapper {

    List<TestQDTO> findContent();
}
