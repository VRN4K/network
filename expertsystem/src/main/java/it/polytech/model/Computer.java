package it.polytech.model;

public class Computer {
    String pc_id;
    String pc_name;
    String pc_price;
    String cpu_family;
    String form_factor;
    String ssd_size;
    String pc_os;
    String gpu_fabricator;
    String core_amount;
    String pc_fabricator;
    String purpose;
    String ram_size;

    public Computer(String pc_id, String pc_name, String pc_price, String cpu_family, String form_factor, String ssd_size, String pc_os,
                    String gpu_fabricator, String core_amount, String pc_fabricator, String purpose, String ram_size) {
        this.pc_id = pc_id;
        this.pc_name = pc_name;
        this.pc_price = pc_price;
        this.cpu_family = cpu_family;
        this.form_factor = form_factor;
        this.ssd_size = ssd_size;
        this.pc_os = pc_os;
        this.gpu_fabricator = gpu_fabricator;
        this.core_amount = core_amount;
        this.pc_fabricator = pc_fabricator;
        this.purpose = purpose;
        this.ram_size = ram_size;
    }

    public Computer(String pc_price, String cpu_family, String form_factor, String ssd_size, String pc_os,
                    String gpu_fabricator, String core_amount, String pc_fabricator, String purpose, String ram_size) {
        this.pc_price = pc_price;
        this.cpu_family = cpu_family;
        this.form_factor = form_factor;
        this.ssd_size = ssd_size;
        this.pc_os = pc_os;
        this.gpu_fabricator = gpu_fabricator;
        this.core_amount = core_amount;
        this.pc_fabricator = pc_fabricator;
        this.purpose = purpose;
        this.ram_size = ram_size;
    }

    public String getPc_id() {
        return pc_id;
    }
    public String getPc_name() {
        return pc_name;
    }

    public void setPc_name(String pc_name) {
        this.pc_name = pc_name;
    }

    public String getPc_price() {
        return pc_price;
    }

    public void setPc_price(String pc_price) {
        this.pc_price = pc_price;
    }

    public String getCpu_family() {
        return cpu_family;
    }

    public void setCpu_family(String cpu_family) {
        this.cpu_family = cpu_family;
    }

    public String getForm_factor() {
        return form_factor;
    }

    public void setForm_factor(String form_factor) {
        this.form_factor = form_factor;
    }

    public String getSsd_size() {
        return ssd_size;
    }

    public void setSsd_size(String ssd_size) {
        this.ssd_size = ssd_size;
    }

    public String getPc_os() {
        return pc_os;
    }

    public void setPc_os(String pc_os) {
        this.pc_os = pc_os;
    }

    public String getGpu_fabricator() {
        return gpu_fabricator;
    }

    public void setGpu_fabricator(String gpu_fabricator) {
        this.gpu_fabricator = gpu_fabricator;
    }

    public String getCore_amount() {
        return core_amount;
    }

    public void setCore_amount(String core_amount) {
        this.core_amount = core_amount;
    }

    public String getPc_fabricator() {
        return pc_fabricator;
    }

    public void setPc_fabricator(String pc_fabricator) {
        this.pc_fabricator = pc_fabricator;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRam_size() {
        return ram_size;
    }

    public void setRam_size(String ram_size) {
        this.ram_size = ram_size;
    }
}
