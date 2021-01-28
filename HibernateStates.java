import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibStates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	//Object is transient now
    	Alien a = new Alien();
    	a.setaColor("green");
    	a.setaName("Jaadu");
    	a.setaId(20013);

    	//object is persistent now
    	session.save(a);
    	a.setaColor("blue"); //This will affect DB value
    	
    	tx.commit(); //It will not be persisted until I do a commit
    	
    	a.setaColor("black"); //This came into transient object again
	}

}
