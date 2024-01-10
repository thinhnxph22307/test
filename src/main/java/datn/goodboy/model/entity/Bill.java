  package datn.goodboy.model.entity;

  import java.time.LocalDateTime;
  import java.util.ArrayList;
  import java.util.List;
  import java.util.UUID;

  import com.fasterxml.jackson.annotation.JsonIgnore;
  import jakarta.persistence.*;
  import lombok.AllArgsConstructor;
  import lombok.Getter;
  import lombok.NoArgsConstructor;
  import lombok.Setter;
  import lombok.ToString;

  @Entity
  @Getter
  @Setter
  @Table(name = "bill")
  @NoArgsConstructor
  @AllArgsConstructor
  @ToString
  public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_pay")
    private Pay pay;

    @Column(name = "code", insertable = false, updatable = false)
    String code;

    @Column(name = "confirmation_date")
    LocalDateTime confirmation_date;

    @Column(name = "delivery_date")
    LocalDateTime delivery_date;

    @Column(name = "received_date")
    LocalDateTime received_date;

    @Column(name = "completion_date")
    LocalDateTime completion_date;

    @Column(name = "customer_name")
    String customer_name;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "money_ship")
    Double money_ship;

    @Column(name = "total_money")
    Double total_money;

    @Column(name = "reduction_amount")
    Double reduction_amount;

    @Column(name = "deposit")
    Double deposit;

    @Column(name = "note")
    String note;

    @Column(name = "status")
    int status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted")
    boolean deleted;

    @Column(name = "order_type")
    int loaiDon;

    @Column(name = "status_pay")
    int status_pay;

    @PrePersist
    protected void onCreate() {

      if (this.money_ship == null) {
        this.money_ship = 0d;
      }
      if (this.total_money == null) {
        this.total_money = 0d;
      }
      if (this.reduction_amount == null) {
        reduction_amount = 0d;
      }
      this.deposit = this.total_money + this.money_ship - this.reduction_amount;
      this.createdAt = LocalDateTime.now();
      this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
      if (this.money_ship == null) {
        this.money_ship = 0d;
      }
      if (this.total_money == null) {
        this.total_money = 0d;
      }
      if (this.reduction_amount == null) {
        reduction_amount = 0d;
      }
      this.deposit = this.total_money + this.money_ship - this.reduction_amount;
      this.updatedAt = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "idBill", cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
    // @JsonIgnore
    private List<BillDetail> billDetail = new ArrayList<BillDetail>();

    @OneToOne(mappedBy = "bill", cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
    @JsonIgnore
    private VoucherDetail voucherDetail;
  }
