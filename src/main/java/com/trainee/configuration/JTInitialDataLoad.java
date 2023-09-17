/*package com.community.api.configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.broadleafcommerce.profile.core.domain.Country;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionCategory;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl;
import org.broadleafcommerce.profile.core.service.CountrySubdivisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.community.core.catalog.domain.JTDCommunity;
import com.community.core.catalog.domain.JTZipcode;
import com.community.core.catalog.domain.impl.JTCountrySubdivisionModel;
import com.community.core.catalog.domain.impl.JTDCommunityImpl;
import com.community.core.catalog.domain.impl.JTZipcodeImpl;
import com.community.core.catalog.service.BLCCountryService;
import com.community.core.catalog.service.JTCountrySubdivisionService;
import com.community.core.catalog.service.JTDCommunityService;
import com.community.core.catalog.service.JTZipCodeService;

@Component
public class JTInitialDataLoad {
	private static final String INDIA = "INDIA";
	private static final String IN = "IN";
	Logger logger = LoggerFactory.getLogger(JTInitialDataLoad.class);

	@Resource(name = "blcCountryService")
	private BLCCountryService blcCountryService;

	@Value("${spring.data.country.load}")
	private Boolean countryLoad;

	@Value("${spring.data.region.load}")
	private Boolean regionLoad;

	@Value("${spring.data.city.load}")
	private Boolean cityLoad;

	@Value("${spring.data.city.load}")
	private Boolean zipcodesLoad;
	
	@Value("${spring.data.community.load}")
	private Boolean communityLoad;

	@Resource(name = "blCountrySubdivisionService")
	private CountrySubdivisionService countrySubdivisionService;

	@Resource(name = "jtCountrySubdivisionService")
	private JTCountrySubdivisionService jtCountrySubdivisionService;
	
	@Resource(name = "jtZipCodeService")
	private JTZipCodeService jtZipCodeService;
	
	@Resource(name = "jtDCommunityService")
	private JTDCommunityService jtDCommunityService;
	
	@Transactional
	public void initialDataLoad() {
		if (null != countryLoad && countryLoad && null == blcCountryService.findByCode(IN)) {
			Country country = new CountryImpl();
			country.setAbbreviation(IN);
			country.setName(INDIA);
			blcCountryService.save(country);
			logger.info("Created country " + country.getName());
		}
		loadRegions();
		loadCities();
		loadZipcodes();
		loadCommunities();
	}

	private void loadRegions() {
		if (null != regionLoad && regionLoad) {
			try {
				Country country = blcCountryService.findByCode(IN);
				File file = ResourceUtils.getFile("classpath:" + "data/regions.csv");
				Path path = file.toPath();
				final Stream<String> lines = Files.lines(path);
				lines.forEach(line -> {
					String[] regionData = line.split(",");
					if (null != regionData && regionData.length > 0) {
						CountrySubdivisionCategory category = jtCountrySubdivisionService
								.findCategory(Long.valueOf(66));
						CountrySubdivision countrySubdivision = countrySubdivisionService
								.findSubdivisionByAbbreviation(regionData[0]);
						if (null == countrySubdivision) {
							countrySubdivision = new CountrySubdivisionImpl();
							countrySubdivision.setAbbreviation(regionData[0]);
							countrySubdivision.setName(regionData[1]);
							countrySubdivision.setAlternateAbbreviation(regionData[2]);
							countrySubdivision.setCountry(country);
							countrySubdivision.setCategory(category);
							countrySubdivisionService.save(countrySubdivision);
						}
					}
				});
			} catch (IOException ex) {
				logger.error(ex.toString());
			} finally {
			}
		}
	}

	private void loadCities() {
		if (null != cityLoad && cityLoad) {
			try {
				File file = ResourceUtils.getFile("classpath:" + "data/cities.csv");
				Path path = file.toPath();
				final Stream<String> lines = Files.lines(path);
				lines.forEach(line -> {
					String[] regionData = line.split(",");
					Country country = blcCountryService.findByCode(IN);
					if (null != regionData && regionData.length > 0) {
						CountrySubdivisionCategory category = jtCountrySubdivisionService
								.findCategory(Long.valueOf(20));
						JTCountrySubdivisionModel countrySubdivision = (JTCountrySubdivisionModel) countrySubdivisionService
								.findSubdivisionByAbbreviation(regionData[0]);
						if (null == countrySubdivision) {
							countrySubdivision = new JTCountrySubdivisionModel();
							countrySubdivision.setAbbreviation(regionData[0]);
							countrySubdivision.setName(regionData[1]);
							countrySubdivision.setAlternateAbbreviation(regionData[2]);
							countrySubdivision.setCategory(category);
							countrySubdivision.setCountry(country);
							CountrySubdivision countryRegion = countrySubdivisionService
									.findSubdivisionByAbbreviation(regionData[3]);
							countrySubdivision.setCountrySubdivision(countryRegion);
							countrySubdivisionService.save(countrySubdivision);
						}
					}
				});
			} catch (IOException ex) {
				logger.error(ex.toString());
			} finally {
			}
		}
	}
	
	private void loadZipcodes() {
		if (null != zipcodesLoad && zipcodesLoad) {
			try {
				File file = ResourceUtils.getFile("classpath:" + "data/zipcodes.csv");
				Path path = file.toPath();
				final Stream<String> lines = Files.lines(path);
				lines.forEach(line -> {
				    String[] regionData = line.split(",");
					if (null != regionData && regionData.length > 0) {	
						Integer data=Integer.valueOf(regionData[0]);
						JTZipcode zipCode = jtZipCodeService.findZipCodeByZipCode(data);
						if (null == zipCode) {							
							zipCode = new JTZipcodeImpl();
							zipCode.setId(regionData[0]);
							zipCode.setJtzipcode(data);
							zipCode.setJtzipState(regionData[1]);
							zipCode.setZipCity(regionData[2]);
							jtZipCodeService.save(zipCode);
						}
					}
				});
			} catch (IOException ex) {
				logger.error(ex.toString());
			} finally {
			}
		}
	}
	
	private void loadCommunities() {
		if (null != communityLoad && communityLoad) {
			try {
				File file = ResourceUtils.getFile("classpath:" + "data/communities.csv");
				Path path = file.toPath();
				final Stream<String> lines = Files.lines(path);
				lines.forEach(line -> {
				    String[] communityData = line.split(",");
					if (null != communityData && communityData.length > 0) {	
						JTDCommunity community = jtDCommunityService.findByCode(communityData[1]);
						if (null == community) {							
							community = new JTDCommunityImpl();
							community.setId(Long.valueOf(communityData[0]));
							community.setCode(communityData[1]);
							community.setName(communityData[2]);
							jtDCommunityService.save(community);
						}
					}
				});
			} catch (IOException ex) {
				logger.error(ex.toString());
			} finally {
			}
		}
	}
}*/
