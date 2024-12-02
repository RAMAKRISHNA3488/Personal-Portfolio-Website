package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.util.List;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Project;

public interface ProjectService {
	List<Project> getAllProjects();

	Project getProjectById(Long id);

	Project createProject(Project project);

	Project updateProject(Long id, Project project);

	void deleteProject(Long id);

}
