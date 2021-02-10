package org.amrani.exo4;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(Commune.class);

		Marshaller marshaller = context.createMarshaller();

		marshaller.setProperty("jaxb.formatted.output", true);

		Commune commune = new Commune("75000", "Paris", 12);

		marshaller.marshal(commune, new File("xml/commune.xml"));

	}

}
