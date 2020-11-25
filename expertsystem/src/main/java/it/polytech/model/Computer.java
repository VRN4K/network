package it.polytech.model;

import java.util.UUID;

public class Computer {
    String pc_id;
    String purpose;
    String cpu_family;
    String ram_size;
    String pc_os;
    String gpu_fabricator;
    String pc_price;
    String cpu_fabricator;
    String core_amount;
    String ssd_size;
    String pc_fabricator;

    public Computer(String pc_id, String purpose, String cpu_family, String ram_size, String pc_os,
                    String gpu_fabricator, String pc_price, String cpu_fabricator, String core_amount,
                    String ssd_size, String pc_fabricator) {
        this.pc_id = pc_id;
        this.purpose = purpose;
        this.cpu_family = cpu_family;
        this.ram_size = ram_size;
        this.pc_os = pc_os;
        this.gpu_fabricator = gpu_fabricator;
        this.pc_price = pc_price;
        this.cpu_fabricator = cpu_fabricator;
        this.core_amount = core_amount;
        this.ssd_size = ssd_size;
        this.pc_fabricator = pc_fabricator;
    }

    public Computer(String purpose, String cpu_family, String ram_size, String pc_os, String gpu_fabricator,
                    String pc_price, String cpu_fabricator, String core_amount, String ssd_size,
                    String pc_fabricator) {
        this.pc_id = UUID.randomUUID().toString();
        this.purpose = purpose;
        this.cpu_family = cpu_family;
        this.ram_size = ram_size;
        this.pc_os = pc_os;
        this.gpu_fabricator = gpu_fabricator;
        this.pc_price = pc_price;
        this.cpu_fabricator = cpu_fabricator;
        this.core_amount = core_amount;
        this.ssd_size = ssd_size;
        this.pc_fabricator = pc_fabricator;
    }

    public String getPc_id() {
        return pc_id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getCpu_family() {
        return cpu_family;
    }

    public void setCpu_family(String cpu_family) {
        this.cpu_family = cpu_family;
    }

    public String getRam_size() {
        return ram_size;
    }

    public void setRam_size(String ram_size) {
        this.ram_size = ram_size;
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

    public String getPc_price() {
        return pc_price;
    }

    public void setPc_price(String pc_price) {
        this.pc_price = pc_price;
    }

    public String getCpu_fabricator() {
        return cpu_fabricator;
    }

    public void setCpu_fabricator(String cpu_fabricator) {
        this.cpu_fabricator = cpu_fabricator;
    }

    public String getCore_amount() {
        return core_amount;
    }

    public void setCore_amount(String core_amount) {
        this.core_amount = core_amount;
    }

    public String getSsd_size() {
        return ssd_size;
    }

    public void setSsd_size(String ssd_size) {
        this.ssd_size = ssd_size;
    }

    public String getPc_fabricator() {
        return pc_fabricator;
    }

    public void setPc_fabricator(String pc_fabricator) {
        this.pc_fabricator = pc_fabricator;
    }
}
