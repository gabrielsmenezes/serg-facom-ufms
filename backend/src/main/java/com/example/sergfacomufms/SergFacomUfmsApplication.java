package com.example.sergfacomufms;


import com.example.sergfacomufms.repository.*;
import com.example.sergfacomufms.domain.interestarea.InterestArea;
import com.example.sergfacomufms.domain.person.Person;
import com.example.sergfacomufms.domain.person.Titulation;
import com.example.sergfacomufms.domain.product.Product;
import com.example.sergfacomufms.domain.product.ProductType;
import com.example.sergfacomufms.domain.professor.Course;
import com.example.sergfacomufms.domain.professor.Professor;
import com.example.sergfacomufms.domain.project.Project;
import com.example.sergfacomufms.domain.publication.Publication;
import com.example.sergfacomufms.domain.researchline.ResearchLine;
import com.example.sergfacomufms.domain.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SergFacomUfmsApplication {

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private PublicationRepository publicationRepository;

	@Autowired
	private ResearchLineRepository researchLineRepository;

	@Autowired
	private InterestAreaRepository interestAreaRepository;

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SergFacomUfmsApplication.class, args);
	}

	@PostConstruct
	public void initiateDatabase() {
		List<InterestArea> interestAreas = saveInterestAreas();

		List<Course> courses = saveCourses();

		List<ResearchLine> researchLines = saveResearchLines();

		List<Project> projects = saveProjects(researchLines);

		List<Publication> publications = savePublications();

		List<Person> people = savePeople(interestAreas, projects, publications);

		List<Product> products = saveProducts();

		Professor brunoProfessor = new Professor();
		brunoProfessor.setCourses(Collections.singletonList(courses.get(1)));
		brunoProfessor.setOwner(people.get(0));
		brunoProfessor = professorRepository.save(brunoProfessor);

		Professor awdrenProfessor = new Professor();
		awdrenProfessor.setCourses(Collections.singletonList(courses.get(2)));
		awdrenProfessor.setOwner(people.get(1));
		professorRepository.saveAll(Arrays.asList(awdrenProfessor));

		Student gabrielStudent = new Student();
		gabrielStudent.setEgressed(Boolean.FALSE);
		gabrielStudent.setAdvisor(brunoProfessor);
		gabrielStudent.setOwner(people.get(2));
		gabrielStudent.setTitulationExpected(Titulation.MASTER);
		studentRepository.save(gabrielStudent);

	}

	private List<Product> saveProducts() {
		Product dcl = new Product("DCL", "http://rterrabh.github.io/DCL/", "domain-specific language for architecture conformance", ProductType.SOFTWARE);
		Product argo = new Product("ArgoUML-SPL", "http://argouml-spl.tigris.org/", "product line variant of ArgoUML", ProductType.DATASET);
		return productRepository.saveAll(Arrays.asList(dcl, argo));
	}

	private List<Person> savePeople(List<InterestArea> interestAreas, List<Project> projects, List<Publication> publications) {
		Person bruno = new Person("Bruno Cafeo", "../assets/professors/001_Bruno_Cafeo.jpg", "Descrição", Titulation.POST_DOCTORAL, Collections.singletonList(interestAreas.get(1)), Collections.singletonList(publications.get(0)), null, Collections.singletonList(projects.get(0)));
		Person awdren = new Person("Awdren Fontão", "../assets/professors/002_Awdren_Fontao.jpg", "Descrição", Titulation.DOCTORAL, Collections.singletonList(interestAreas.get(0)),null, null, null);
		Person gabriel = new Person("Gabriel Menezes", "../assets/students/001_Gabriel_Menezes.jpg", null, Titulation.GRADUATE, null, Collections.singletonList(publications.get(0)), null, Collections.singletonList(projects.get(0)));

		return personRepository.saveAll(Arrays.asList(bruno, awdren, gabriel));
	}

	private List<Publication> savePublications() {
		Publication esem2019 = new Publication("@inproceedings{menezes2019framework,title={Framework Code Samples: How Are They Maintained and Used by Developers?},author={Menezes, Gabriel and Cafeo, Bruno and Hora, Andre},booktitle={2019 ACM/IEEE International Symposium on Empirical Software Engineering and Measurement (ESEM)},pages={1--11},year={2019},organization={IEEE}}", Boolean.TRUE, "https://arxiv.org/abs/1907.05564", "https://ieeexplore.ieee.org/abstract/document/8870139", null, null);
		return publicationRepository.saveAll(Arrays.asList(esem2019));
	}

	private List<Project> saveProjects(List<ResearchLine> researchLines) {
		Project codeSamples = new Project("Code Samples research", "This research ain to fill the gap in code samples literature", "CNPq", null, new Date(), new Date(), Collections.singletonList(researchLines.get(2)), null);
		return projectRepository.saveAll(Arrays.asList(codeSamples));
	}

	private List<ResearchLine> saveResearchLines() {
		ResearchLine configurableSystems = new ResearchLine("Configurable Systems", "A system configuration (SC) in systems engineering defines the computers, processes, and devices that compose the system and its boundary. More generally, the system configuration is the specific definition of the elements that define and/or prescribe what a system is composed of.");
		ResearchLine softwareEcosystem = new ResearchLine("Software Ecosystems", "Software Ecosystem is a book written by David G. Messerschmitt and Clemens Szyperski that explains the essence and effects of a \"software ecosystem\", defined as a set of businesses functioning as a unit and interacting with a shared market for software and services, together with relationships among them. These relationships are frequently underpinned by a common technological platform and operate through the exchange of information, resources, and artifacts.");
		ResearchLine softwareEvolution = new ResearchLine("Software Evolution", "Software evolution in software engineering defines evolution of software");

		return researchLineRepository.saveAll(Arrays.asList(configurableSystems, softwareEcosystem, softwareEvolution));
	}

	private List<Course> saveCourses() {
		Course softwareMaintenance = new Course("Software Maintenance");
		Course softwareTest = new Course("Software Test");
		Course softwareProcess = new Course("Software Process");

		return courseRepository.saveAll(Arrays.asList(softwareMaintenance, softwareTest, softwareProcess));
	}

	private List<InterestArea> saveInterestAreas() {
		InterestArea robots = new InterestArea("Robots");
		InterestArea softwareEngineering = new InterestArea("Software Engineering");
		InterestArea softwareTest = new InterestArea("Software Test");

		return interestAreaRepository.saveAll(Arrays.asList(robots, softwareEngineering, softwareTest));
	}
}