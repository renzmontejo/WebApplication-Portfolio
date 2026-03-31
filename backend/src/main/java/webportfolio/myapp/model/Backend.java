package webportfolio.myapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "backend")
public class Backend {
    @Id
    @Column(name = "backend_id")
    private String backendId;

    @Column(name = "backend_name")
    private String backendName;
}
