package vnt.com.msscbrewery.services.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vnt.com.msscbrewery.web.model.v2.BeerDtoV2;
import vnt.com.msscbrewery.web.model.v2.BeerStyleEnum;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2{
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(beerId)
                .beerStyle(BeerStyleEnum.LAGER)
                .beerName("xxx")
                .build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
         log.debug("Updating...");
    }

    @Override
    public void deleteById(UUID beerId) {
          log.debug("Deleting...");
    }
}
