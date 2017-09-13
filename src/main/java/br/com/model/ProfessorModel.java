package br.com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.core.GenericModel;
import br.com.entity.ProfessorEntity;

@Repository
@Transactional
public class ProfessorModel extends GenericModel<ProfessorEntity>{


}
