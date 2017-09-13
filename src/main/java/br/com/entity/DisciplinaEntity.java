package br.com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DisciplinaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private Integer periodo;
	
	@Column(name = "data_inicio", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@ManyToOne
	private ProfessorEntity professor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public ProfessorEntity getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorEntity professor) {
		this.professor = professor;
	}
	
	
	
}
