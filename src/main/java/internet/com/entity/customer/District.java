package internet.com.entity.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "district_name")
    private String districtName;

    @OneToMany(mappedBy = "district")
    @JsonBackReference( "commune")
    private List<Commune> communes;

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    private Province province;

    public District() {
    }

    public District(int id, String districtName, List<Commune> communes, Province province) {
        this.id = id;
        this.districtName = districtName;
        this.communes = communes;
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}