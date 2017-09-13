package br.com.entity;

import java.util.List;

import javax.persistence.*;


@Entity
@Table (name= "matricula")
public class MatriculaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany
	private List<DisciplinaEntity> disciplinas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public List<DisciplinaEntity> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<DisciplinaEntity> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	
}

