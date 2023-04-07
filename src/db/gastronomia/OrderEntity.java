package db.gastronomia;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

@Entity
@Table(name = "ordini")
public class OrderEntity implements JpaEntity {

	private static final long serialVersionUID = 1L;
//creo oggetto per ocntesto di persistenza da usare sul main per CRUD
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_clienti")
	private ClientiEntity clientiEntity;

	public OrderEntity() {}
	
	public OrderEntity(Long id, ClientiEntity clientiEntity) {
		super();
		this.id = id;
		this.clientiEntity = clientiEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClientiEntity getClientiEntity() {
		return clientiEntity;
	}

	public void setClientiEntity(ClientiEntity clientiEntity) {
		this.clientiEntity = clientiEntity;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}





}
