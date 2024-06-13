package com.potless.backend.hexagon.service;

import com.potless.backend.hexagon.entity.HexagonEntity;
import com.potless.backend.hexagon.repository.HexagonRepository;
import com.uber.h3core.H3Core;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HexagonService {
    private final H3Core h3Core;
    private final HexagonRepository hexagonRepository;

    public HexagonEntity getHexagon(String hexagonIndex) {
        return hexagonRepository.findByHexagonIndex(hexagonIndex);
    }

    public String getH3Index(double latitude, double longitude, int resolution) {
        Long h3Index = h3Core.geoToH3(latitude, longitude, resolution);
        return Long.toHexString(h3Index);
    }


}