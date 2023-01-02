package com.ozi.petalk.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ozi.petalk.model.AnimalBreedList;
import com.ozi.petalk.model.AnimalSpeciesList;
import com.ozi.petalk.model.PetalkDeviceColorList;
import com.ozi.petalk.model.PetalkDeviceTriggerTypeList;
import com.ozi.petalk.model.PetalkDeviceTypeList;


@Component
public class LoadPetalkDatabaseListTables implements CommandLineRunner {
	@Autowired
	AnimalBreedListService animalBreedListService;
	@Autowired
	AnimalSpeciesListService animalSpeciesListService;
	@Autowired
	PetalkDeviceColorListService petalkDeviceColorListService;
	@Autowired
	PetalkDeviceTriggerTypeListService petalkDeviceTriggerTypeListService;
	@Autowired
	PetalkDeviceTypeListService petalkDeviceTypeListService;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	String databaseConfig;
	@Override
	public void run(String... args) throws Exception {
		//load the list tables if the properties file is set to "create-drop"
		if(databaseConfig.equalsIgnoreCase("create"))
		{
			AnimalBreedList animalBreedList1 = new AnimalBreedList(1, "maltese","no-scientific-name","");
			AnimalBreedList animalBreedList2 = new AnimalBreedList(2, "Golden retriever","no-scientific-name","");
			AnimalSpeciesList animalSpeciesList1 = new AnimalSpeciesList(1, "dog");
			AnimalSpeciesList animalSpeciesList2 = new AnimalSpeciesList(2, "cat");
			PetalkDeviceColorList petalkDeviceColorList1 = new PetalkDeviceColorList(1, "black");
			PetalkDeviceColorList petalkDeviceColorList2 = new PetalkDeviceColorList(2, "blue");
			PetalkDeviceTriggerTypeList petalkDeviceTriggerTypeList1 = new PetalkDeviceTriggerTypeList(1, "first_turned_on");
			PetalkDeviceTriggerTypeList petalkDeviceTriggerTypeList2 = new PetalkDeviceTriggerTypeList(2, "Animal_Wants_Food");
			PetalkDeviceTriggerTypeList petalkDeviceTriggerTypeList3 = new PetalkDeviceTriggerTypeList(1, "Animal_Wants_Water");
			PetalkDeviceTriggerTypeList petalkDeviceTriggerTypeList4 = new PetalkDeviceTriggerTypeList(2, "Animal_Wants_Something_Else");
			PetalkDeviceTypeList petalkDeviceTypeList1 = new PetalkDeviceTypeList(1, "basic", LocalDateTime.now(), 20.00f);
			PetalkDeviceTypeList petalkDeviceTypeList2 = new PetalkDeviceTypeList(2, "premium", LocalDateTime.now(), 30.00f);

			animalBreedListService.saveAll(List.of(animalBreedList1, animalBreedList2));
			animalSpeciesListService.saveAll(List.of(animalSpeciesList1, animalSpeciesList2));
			petalkDeviceColorListService.saveAll(List.of(petalkDeviceColorList1, petalkDeviceColorList2));
			petalkDeviceTriggerTypeListService.saveAll(List.of(petalkDeviceTriggerTypeList1, petalkDeviceTriggerTypeList2, petalkDeviceTriggerTypeList3, petalkDeviceTriggerTypeList4));
			petalkDeviceTypeListService.saveAll(List.of(petalkDeviceTypeList1, petalkDeviceTypeList2));
			

			
			
		}
	}

}
