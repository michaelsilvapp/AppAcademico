package br.com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import br.com.entity.AlunoEntity;
import br.com.entity.DisciplinaEntity;
import br.com.entity.MatriculaEntity;
import br.com.entity.ProfessorEntity;
import br.com.model.AlunoModel;
import br.com.model.DiciplinaModel;
import br.com.model.MatriculaModel;
import br.com.model.ProfessorModel;

@ComponentScan(basePackages={"br.com"})
public class AppAcademicoRun {

	public static void main(String[] args) {
		
		aluno(); 
	
	}
	
	
	public static void aluno() {
		ConfigurableApplicationContext context = SpringApplication.run(AppAcademicoRun.class);
		
		AlunoModel alunoModel = context.getBean(AlunoModel.class);
		
		AlunoEntity alunoChaview = new AlunoEntity();
		alunoChaview.setNome("Chaview");
		alunoChaview.setAtivo(false);
		alunoChaview.setCpf("123214235436");
		alunoChaview.setDataInicio(new Date());
		alunoModel.create(alunoChaview);
		
		ProfessorModel profesorModel = context.getBean(ProfessorModel.class);
		
		ProfessorEntity professor1 = new ProfessorEntity();
		professor1.setNome("Marcos");
		professor1.setCpf("12332154399");
		professor1.setIdade(35);
		profesorModel.create(professor1);
		
		ProfessorEntity professor2 = new ProfessorEntity();
		professor2.setNome("Julio");
		professor2.setCpf("12332154499");
		professor2.setIdade(45);
		profesorModel.create(professor2);
		
		ProfessorEntity professor3 = new ProfessorEntity();
		professor3.setNome("João");
		professor3.setCpf("17332154399");
		professor3.setIdade(32);
		profesorModel.create(professor3);
		
		List<ProfessorEntity> professores = profesorModel.getAll(ProfessorEntity.class);
		for(ProfessorEntity professor : professores)
			System.out.println(professor.toString());
		
		 context.close();
		
		//DisciplinaEntity
		
		DiciplinaModel diciplinaModel = context.getBean(DiciplinaModel.class); 
		
		DisciplinaEntity dis1 = new DisciplinaEntity();
		dis1.setDataInicio(new Date());
		dis1.setPeriodo(5);
		dis1.setProfessor(professor1);
		diciplinaModel.create(dis1);
		
		DisciplinaEntity dis2 = new DisciplinaEntity();
		dis2.setDataInicio(new Date());
		dis2.setPeriodo(5);
		dis2.setProfessor(professor2);
		diciplinaModel.create(dis2);
		
		DisciplinaEntity dis3 = new DisciplinaEntity();
		dis3.setDataInicio(new Date());
		dis3.setPeriodo(5);
		dis3.setProfessor(professor3);
		diciplinaModel.create(dis3);
		
		DisciplinaEntity dis4 = new DisciplinaEntity();
		dis4.setDataInicio(new Date());
		dis4.setPeriodo(5);
		dis4.setProfessor(professor2);
		diciplinaModel.create(dis4);
		
		MatriculaModel matriculaModel = context.getBean(MatriculaModel.class); 
		
		MatriculaEntity mat1 = new MatriculaEntity();
		matriculaModel.create(mat1);
		
		MatriculaEntity mat2 = new MatriculaEntity();
		matriculaModel.create(mat2);
		
		MatriculaEntity mat3 = new MatriculaEntity();
		matriculaModel.create(mat3);
		
		MatriculaEntity mat4 = new MatriculaEntity();
		matriculaModel.create(mat4);
		
		MatriculaEntity mat5 = new MatriculaEntity();
		matriculaModel.create(mat5);
		
		
		
		List<AlunoEntity> alunos = alunoModel.getAll(AlunoEntity.class);
		for(AlunoEntity aluno : alunos)
			System.out.println(aluno.toString());
		
		AlunoEntity alunoEncontrado = alunoModel.getByCpf("123214235436"); 
		alunoEncontrado.getMatricula().getDisciplinas().add(dis4);
		
		alunoModel.update(alunoEncontrado);
		
		
		 context.close();
		
	}
	

}