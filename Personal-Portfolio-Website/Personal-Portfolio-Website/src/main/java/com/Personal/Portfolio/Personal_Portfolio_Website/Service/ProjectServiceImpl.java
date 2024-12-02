package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Project;
import com.Personal.Portfolio.Personal_Portfolio_Website.Repos.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(Long id) {
		return projectRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
	}

	@Override
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project updateProject(Long id, Project project) {
		Project existingProject = getProjectById(id);
		existingProject.setTitle(project.getTitle());
		existingProject.setDescription(project.getDescription());
		existingProject.setTechnologies(project.getTechnologies());
		existingProject.setLiveLink(project.getLiveLink());
		return projectRepository.save(existingProject);
	}

	@Override
	public void deleteProject(Long id) {
		if (!projectRepository.existsById(id)) {
			throw new RuntimeException("Project not found with id: " + id);
		}
		projectRepository.deleteById(id);

	}

}
