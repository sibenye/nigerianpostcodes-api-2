package com.elsynergy.nigerianpostcodes.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.elsynergy.nigerianpostcodes.mapper.FacilityPostcodeResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.RuralPostcodeResponseMapper;
import com.elsynergy.nigerianpostcodes.mapper.UrbanPostcodeResponseMapper;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.LocalGovernmentArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.RuralArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.State;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanArea;
import com.elsynergy.nigerianpostcodes.model.DAO.geograpghyentities.UrbanTown;
import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.FacilityPostcode;
import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.RuralPostcode;
import com.elsynergy.nigerianpostcodes.model.DAO.postcodeentities.UrbanPostcode;
import com.elsynergy.nigerianpostcodes.model.request.FacilityPostcodeRequest;
import com.elsynergy.nigerianpostcodes.model.request.RuralPostcodeRequest;
import com.elsynergy.nigerianpostcodes.model.request.UrbanPostcodeRequest;
import com.elsynergy.nigerianpostcodes.repo.postcodeentities.FacilityPostcodeRepositoryCustom;
import com.elsynergy.nigerianpostcodes.repo.postcodeentities.PostcodeRepositoryCustom;
import com.elsynergy.nigerianpostcodes.repo.postcodeentities.RuralPostcodeRepositoryCustom;
import com.elsynergy.nigerianpostcodes.repo.postcodeentities.UrbanPostcodeRepositoryCustom;
import com.elsynergy.nigerianpostcodes.service.postcodeentities.PostcodeService;
import com.elsynergy.nigerianpostcodes.web.exception.ResourceNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class PostcodeServiceTest
{
    @Mock
    private FacilityPostcodeRepositoryCustom facilityPostcodeRepository;

    @Mock
    private RuralPostcodeRepositoryCustom ruralPostcodeRepository;

    @Mock
    private UrbanPostcodeRepositoryCustom urbanPostcodeRepository;

    @Mock
    private PostcodeRepositoryCustom postcodeRepository;

    @Mock
    private FacilityPostcodeResponseMapper facilityPostcodeResponseMapper;

    @Mock
    private RuralPostcodeResponseMapper ruralPostcodeResponseMapper;

    @Mock
    private UrbanPostcodeResponseMapper urbanPostcodeResponseMapper;

    @InjectMocks
    private PostcodeService postcodeService;

    private FacilityPostcode facilityPostcode;

    private RuralPostcode ruralPostcode;

    private UrbanPostcode urbanPostcode;

    private FacilityPostcodeRequest facilityPostcodeRequest;

    private RuralPostcodeRequest ruralPostcodeRequest;

    private UrbanPostcodeRequest urbanPostcodeRequest;

    @Before
    public void setup()
    {
        final State state = new State();
        state.setCode("AB");
        state.setName("Abia");

        final LocalGovernmentArea localGovernmentArea = new LocalGovernmentArea();
        localGovernmentArea.setId(1);
        localGovernmentArea.setName("testLga");
        localGovernmentArea.setState(state);

        final UrbanTown urbanTown = new UrbanTown();
        urbanTown.setName("testTown");
        urbanTown.setState(state);

        final UrbanArea urbanArea = new UrbanArea();
        urbanArea.setName("testDestrict");
        urbanArea.setPostcode("120983");
        urbanArea.setUrbanTown(urbanTown);

        final RuralArea ruralArea = new RuralArea();
        ruralArea.setName("testArea");
        ruralArea.setPostcode("120983");
        ruralArea.setLocalGovernmentArea(localGovernmentArea);


        this.facilityPostcode = new FacilityPostcode();
        this.facilityPostcode.setId(1);
        this.facilityPostcode.setFacility("testFacility");
        this.facilityPostcode.setPostcode("120983");
        this.facilityPostcode.setLocalGovernmentArea(localGovernmentArea);

        this.ruralPostcode = new RuralPostcode();
        this.ruralPostcode.setId(1);
        this.ruralPostcode.setTown("testTown");
        this.ruralPostcode.setRuralArea(ruralArea);;

        this.urbanPostcode = new UrbanPostcode();
        this.urbanPostcode.setId(1);
        this.urbanPostcode.setStreet("testStreet");
        this.urbanPostcode.setUrbanArea(urbanArea);

        this.facilityPostcodeRequest = new FacilityPostcodeRequest();
        this.facilityPostcodeRequest.setStateCode("AB");
        this.facilityPostcodeRequest.setLocalGovtAreaName("testLga");
        this.facilityPostcodeRequest.setFacilityName("testFacility");

        this.ruralPostcodeRequest = new RuralPostcodeRequest();
        this.ruralPostcodeRequest.setStateCode("AB");
        this.ruralPostcodeRequest.setLocalGovtAreaName("testLga");
        this.ruralPostcodeRequest.setDistrict("testDistrict");
        this.ruralPostcodeRequest.setTown("testTown");

        this.urbanPostcodeRequest = new UrbanPostcodeRequest();
        this.urbanPostcodeRequest.setStateCode("AB");
        this.urbanPostcodeRequest.setArea("testArea");
        this.urbanPostcodeRequest.setTown("testTown");
        this.urbanPostcodeRequest.setStreet("testStreet");
    }

    @Test
    public void testGetFacilityPostcodesWithStateCodeAndLgaNameAndFacilityName() throws ResourceNotFoundException
    {
        final List<FacilityPostcode> facilityPostcodes = Arrays.asList(this.facilityPostcode);

        when(this.facilityPostcodeRepository.getFacilityPostcodes(
                anyString(), anyString(), anyString())).thenReturn(facilityPostcodes);

        this.postcodeService.getFacilityPostcodes(this.facilityPostcodeRequest);

        verify(this.facilityPostcodeRepository, times(1)).getFacilityPostcodes(
                anyString(), anyString(), anyString());

        verify(this.facilityPostcodeResponseMapper, atLeastOnce()).map(any(FacilityPostcode.class));
    }

    @Test
    public void testGetFacilityPostcodesWithStateCodeAndLgaName() throws ResourceNotFoundException
    {
        final List<FacilityPostcode> facilityPostcodes = Arrays.asList(this.facilityPostcode);

        when(this.facilityPostcodeRepository.getFacilityPostcodes(
                anyString(), anyString(), anyString())).thenReturn(facilityPostcodes);

        this.facilityPostcodeRequest.setFacilityName(null);

        this.postcodeService.getFacilityPostcodes(this.facilityPostcodeRequest);

        verify(this.facilityPostcodeRepository, times(1)).getFacilityPostcodes(
                anyString(), anyString(), anyString());

        verify(this.facilityPostcodeResponseMapper, atLeastOnce()).map(any(FacilityPostcode.class));
    }

    @Test
    public void testGetFacilityPostcodesWithStateCode() throws ResourceNotFoundException
    {
        final List<FacilityPostcode> facilityPostcodes = Arrays.asList(this.facilityPostcode);

        when(this.facilityPostcodeRepository.getFacilityPostcodes(
                anyString(), anyString(), anyString())).thenReturn(facilityPostcodes);

        this.facilityPostcodeRequest.setFacilityName(null);
        this.facilityPostcodeRequest.setLocalGovtAreaName(null);

        this.postcodeService.getFacilityPostcodes(this.facilityPostcodeRequest);

        verify(this.facilityPostcodeRepository, times(1)).getFacilityPostcodes(
                anyString(), anyString(), anyString());

        verify(this.facilityPostcodeResponseMapper, atLeastOnce()).map(any(FacilityPostcode.class));
    }


    @Test(expected=ResourceNotFoundException.class)
    public void testGetFacilityPostcodesWillThrow() throws ResourceNotFoundException
    {
        final List<FacilityPostcode> facilityPostcodes = new ArrayList<>();

        when(this.facilityPostcodeRepository.getFacilityPostcodes(
                anyString(), anyString(), anyString())).thenReturn(facilityPostcodes);

        this.postcodeService.getFacilityPostcodes(this.facilityPostcodeRequest);

        verify(this.facilityPostcodeRepository, times(1)).getFacilityPostcodes(
                anyString(), anyString(), anyString());

        verify(this.facilityPostcodeResponseMapper, times(0)).map(any(FacilityPostcode.class));
    }

    @Test
    public void testGetRuralPostcodesWithStateCodeAndLgaNameAndDistrictAndTown() throws ResourceNotFoundException
    {
        final List<RuralPostcode> ruralPostcodes = Arrays.asList(this.ruralPostcode);

        when(this.ruralPostcodeRepository.getRuralPostcodes(
                anyString(), anyString(), anyString(), anyString())).thenReturn(ruralPostcodes);

        this.postcodeService.getRuralPostcodes(this.ruralPostcodeRequest);

        verify(this.ruralPostcodeRepository, times(1)).getRuralPostcodes(
                anyString(), anyString(), anyString(), anyString());

        verify(this.ruralPostcodeResponseMapper, atLeastOnce()).map(any(RuralPostcode.class));
    }

    @Test
    public void testGetRuralPostcodesWithStateCodeAndLgaNameAndDistrict() throws ResourceNotFoundException
    {
        final List<RuralPostcode> ruralPostcodes = Arrays.asList(this.ruralPostcode);

        when(this.ruralPostcodeRepository.getRuralPostcodes(
                anyString(), anyString(), anyString(), anyString())).thenReturn(ruralPostcodes);

        this.ruralPostcodeRequest.setTown(null);

        this.postcodeService.getRuralPostcodes(this.ruralPostcodeRequest);

        verify(this.ruralPostcodeRepository, times(1)).getRuralPostcodes(
                anyString(), anyString(), anyString(), anyString());

        verify(this.ruralPostcodeResponseMapper, atLeastOnce()).map(any(RuralPostcode.class));
    }

    @Test
    public void testGetRuralPostcodesWithStateCodeAndLgaName() throws ResourceNotFoundException
    {
        final List<RuralPostcode> ruralPostcodes = Arrays.asList(this.ruralPostcode);

        when(this.ruralPostcodeRepository.getRuralPostcodes(
                anyString(), anyString(), anyString(), anyString())).thenReturn(ruralPostcodes);

        this.ruralPostcodeRequest.setTown(null);
        this.ruralPostcodeRequest.setDistrict(null);

        this.postcodeService.getRuralPostcodes(this.ruralPostcodeRequest);

        verify(this.ruralPostcodeRepository, times(1)).getRuralPostcodes(
                anyString(), anyString(), anyString(), anyString());

        verify(this.ruralPostcodeResponseMapper, atLeastOnce()).map(any(RuralPostcode.class));
    }

    @Test
    public void testGetRuralPostcodesWithStateCode() throws ResourceNotFoundException
    {
        final List<RuralPostcode> ruralPostcodes = Arrays.asList(this.ruralPostcode);

        when(this.ruralPostcodeRepository.getRuralPostcodes(
                anyString(), anyString(), anyString(), anyString())).thenReturn(ruralPostcodes);

        this.ruralPostcodeRequest.setTown(null);
        this.ruralPostcodeRequest.setDistrict(null);
        this.ruralPostcodeRequest.setLocalGovtAreaName(null);

        this.postcodeService.getRuralPostcodes(this.ruralPostcodeRequest);

        verify(this.ruralPostcodeRepository, times(1)).getRuralPostcodes(
                anyString(), anyString(), anyString(), anyString());

        verify(this.ruralPostcodeResponseMapper, atLeastOnce()).map(any(RuralPostcode.class));
    }

    @Test(expected=ResourceNotFoundException.class)
    public void testGetRuralPostcodesWillThrow() throws ResourceNotFoundException
    {
        final List<RuralPostcode> ruralPostcodes = new ArrayList<>();

        when(this.ruralPostcodeRepository.getRuralPostcodes(
                anyString(), anyString(), anyString(), anyString())).thenReturn(ruralPostcodes);

        this.postcodeService.getRuralPostcodes(this.ruralPostcodeRequest);

        verify(this.ruralPostcodeRepository, times(1)).getRuralPostcodes(
                anyString(), anyString(), anyString(), anyString());

        verify(this.ruralPostcodeResponseMapper, times(0)).map(any(RuralPostcode.class));
    }

    @Test
    public void testGetUrbanPostcodesWithStateCodeAndTownAndAreaAndStreet() throws ResourceNotFoundException
    {
        final List<UrbanPostcode> urbanPostcodes = Arrays.asList(this.urbanPostcode);

        when(this.urbanPostcodeRepository.getUrbanPostcodes(
                anyString(), anyString(), anyString(), anyString()))
                .thenReturn(urbanPostcodes);

        this.postcodeService.getUrbanPostcodes(this.urbanPostcodeRequest);

        verify(this.urbanPostcodeRepository, times(1)).getUrbanPostcodes(
                anyString(), anyString(), anyString(), anyString());

        verify(this.urbanPostcodeResponseMapper, atLeastOnce()).map(any(UrbanPostcode.class));
    }

    @Test
    public void testGetUrbanPostcodesWithStateCodeAndTownAndArea() throws ResourceNotFoundException
    {
        final List<UrbanPostcode> urbanPostcodes = Arrays.asList(this.urbanPostcode);

        when(this.urbanPostcodeRepository.getUrbanPostcodes(
                anyString(), anyString(), anyString(), anyString()))
                .thenReturn(urbanPostcodes);

        this.urbanPostcodeRequest.setStreet(null);

        this.postcodeService.getUrbanPostcodes(this.urbanPostcodeRequest);

        verify(this.urbanPostcodeRepository, times(1)).getUrbanPostcodes(
                anyString(), anyString(), anyString(), anyString());

        verify(this.urbanPostcodeResponseMapper, atLeastOnce()).map(any(UrbanPostcode.class));
    }

    @Test
    public void testGetUrbanPostcodesWithStateCodeAndTown() throws ResourceNotFoundException
    {
        final List<UrbanPostcode> urbanPostcodes = Arrays.asList(this.urbanPostcode);

        when(this.urbanPostcodeRepository.getUrbanPostcodes(
                anyString(), anyString(), anyString(), anyString()))
                .thenReturn(urbanPostcodes);

        this.urbanPostcodeRequest.setStreet(null);
        this.urbanPostcodeRequest.setArea(null);

        this.postcodeService.getUrbanPostcodes(this.urbanPostcodeRequest);

        verify(this.urbanPostcodeRepository, times(1)).getUrbanPostcodes(
                anyString(), anyString(), anyString(), anyString());

        verify(this.urbanPostcodeResponseMapper, atLeastOnce()).map(any(UrbanPostcode.class));
    }

    @Test
    public void testGetUrbanPostcodesWithStateCode() throws ResourceNotFoundException
    {
        final List<UrbanPostcode> urbanPostcodes = Arrays.asList(this.urbanPostcode);

        when(this.urbanPostcodeRepository.getUrbanPostcodes(
                anyString(), anyString(), anyString(), anyString()))
                .thenReturn(urbanPostcodes);

        this.urbanPostcodeRequest.setStreet(null);
        this.urbanPostcodeRequest.setArea(null);
        this.urbanPostcodeRequest.setTown(null);

        this.postcodeService.getUrbanPostcodes(this.urbanPostcodeRequest);

        verify(this.urbanPostcodeRepository, times(1)).getUrbanPostcodes(
                anyString(), anyString(), anyString(), anyString());

        verify(this.urbanPostcodeResponseMapper, atLeastOnce()).map(any(UrbanPostcode.class));
    }

    @Test(expected=ResourceNotFoundException.class)
    public void testGetUrbanPostcodesWillThrow() throws ResourceNotFoundException
    {
        final List<UrbanPostcode> urbanPostcodes = new ArrayList<>();

        when(this.urbanPostcodeRepository.getUrbanPostcodes(
                anyString(), anyString(), anyString(), anyString()))
                .thenReturn(urbanPostcodes);

        this.postcodeService.getUrbanPostcodes(this.urbanPostcodeRequest);

        verify(this.urbanPostcodeRepository, times(1)).getUrbanPostcodes(
                anyString(), anyString(), anyString(), anyString());

        verify(this.urbanPostcodeResponseMapper, times(0)).map(any(UrbanPostcode.class));
    }

    @Test
    public void testSearchUrbanPostcodes()
    {
        final List<UrbanPostcode> urbanPostcodes = Arrays.asList(this.urbanPostcode);

        when(this.urbanPostcodeRepository.searchUrbanPostcodes(
                anyString(), anyString(), anyString()))
                .thenReturn(urbanPostcodes);

        this.postcodeService.searchUrbanPostcodes("testState", "testTown", "testHint");

        verify(this.urbanPostcodeRepository, times(1)).searchUrbanPostcodes(
                anyString(), anyString(), anyString());

        verify(this.urbanPostcodeResponseMapper, atLeastOnce()).map(any(UrbanPostcode.class));
    }

    @Test
    public void testSearchUrbanPostcodesWillNotThrow()
    {
        final List<UrbanPostcode> urbanPostcodes = new ArrayList<>();

        when(this.urbanPostcodeRepository.searchUrbanPostcodes(
                anyString(), anyString(), anyString()))
                .thenReturn(urbanPostcodes);

        this.postcodeService.searchUrbanPostcodes("testState", "testTown", "testHint");

        verify(this.urbanPostcodeRepository, times(1)).searchUrbanPostcodes(
                anyString(), anyString(), anyString());

        verify(this.urbanPostcodeResponseMapper, times(0)).map(any(UrbanPostcode.class));
    }

    @Test
    public void testReverseLookup() throws ResourceNotFoundException
    {
        final String postcode = "12345";
        //test rural
        final List<RuralPostcode> ruralPostcodes = Arrays.asList(this.ruralPostcode);

        when(this.postcodeRepository.getPostcodeType(
                anyString()))
                .thenReturn("rural");

        when(this.ruralPostcodeRepository.reverseLookup(postcode)).thenReturn(ruralPostcodes);

        this.postcodeService.reverseLookup(postcode);

        verify(this.ruralPostcodeRepository, times(1)).reverseLookup(anyString());
        verify(this.ruralPostcodeResponseMapper, atLeastOnce()).map(any(RuralPostcode.class));

        //test urban
        final List<UrbanPostcode> urbanPostcodes = Arrays.asList(this.urbanPostcode);

        when(this.postcodeRepository.getPostcodeType(
                anyString()))
                .thenReturn("urban");

        when(this.urbanPostcodeRepository.reverseLookup(postcode)).thenReturn(urbanPostcodes);

        this.postcodeService.reverseLookup(postcode);

        verify(this.urbanPostcodeRepository, times(1)).reverseLookup(anyString());
        verify(this.urbanPostcodeResponseMapper, atLeastOnce()).map(any(UrbanPostcode.class));

        //test facility
        final List<FacilityPostcode> facilityPostcodes = Arrays.asList(this.facilityPostcode);

        when(this.postcodeRepository.getPostcodeType(
                anyString()))
                .thenReturn("facility");

        when(this.facilityPostcodeRepository.reverseLookup(postcode)).thenReturn(facilityPostcodes);

        this.postcodeService.reverseLookup(postcode);

        verify(this.facilityPostcodeRepository, times(1)).reverseLookup(anyString());
        verify(this.facilityPostcodeResponseMapper, atLeastOnce()).map(any(FacilityPostcode.class));

    }


    @Test(expected=ResourceNotFoundException.class)
    public void testReverseLookupWillThrow() throws ResourceNotFoundException
    {
        final String postcode = "12345";
        final String type = null;

        when(this.postcodeRepository.getPostcodeType(
                anyString()))
                .thenReturn(type);

        this.postcodeService.reverseLookup(postcode);

        verify(this.ruralPostcodeRepository, times(0)).reverseLookup(anyString());
        verify(this.ruralPostcodeResponseMapper, times(0)).map(any(RuralPostcode.class));

        verify(this.urbanPostcodeRepository, times(0)).reverseLookup(anyString());
        verify(this.urbanPostcodeResponseMapper, times(0)).map(any(UrbanPostcode.class));

        verify(this.facilityPostcodeRepository, times(0)).reverseLookup(anyString());
        verify(this.facilityPostcodeResponseMapper, times(0)).map(any(FacilityPostcode.class));
    }

}
