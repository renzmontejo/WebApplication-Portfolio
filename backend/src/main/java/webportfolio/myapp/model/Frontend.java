package webportfolio.myapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Table(name = "frontend")
public class Frontend {
    @Id
    @Column(name = "backend_id")
    private String backendId;

    @Id
    @Column(name = "backend_name")
    private String backendName;
}
