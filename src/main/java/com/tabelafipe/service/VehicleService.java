package com.tabelafipe.service;

import com.tabelafipe.dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    List<VehicleDto> listByBrand(Long idBrand);

    List<String> listDevaluations(Long idBrand, Long idModel);

}
