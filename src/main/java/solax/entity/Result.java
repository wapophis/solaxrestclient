package solax.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private String inverterSN;
    private String sn;
    private Double acpower;
    private Double yieldtoday;
    private Double yieldtotal;
    private Double feedinpower;
    private Double feedinenergy;
    private Double consumeenergy;
    private Double feedinpowerM2;
    private Double soc;
    private Double peps1;
    private Double peps2;
    private Double peps3;
    private String inverterType;
    private String inverterStatus;
    private String uploadTime;
    private Double batPower;
    private Double powerdc1;
    private Double powerdc2;
    private Double powerdc3;
    private Double powerdc4;

    public String getInverterSN() {
        return inverterSN;
    }

    public void setInverterSN(String inverterSN) {
        this.inverterSN = inverterSN;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Double getAcpower() {
        return acpower;
    }

    public void setAcpower(Double acpower) {
        this.acpower = acpower;
    }

    public Double getYieldtoday() {
        return yieldtoday;
    }

    public void setYieldtoday(Double yieldtoday) {
        this.yieldtoday = yieldtoday;
    }

    public Double getYieldtotal() {
        return yieldtotal;
    }

    public void setYieldtotal(Double yieldtotal) {
        this.yieldtotal = yieldtotal;
    }

    public Double getFeedinpower() {
        return feedinpower;
    }

    public void setFeedinpower(Double feedingpower) {
        this.feedinpower = feedingpower;
    }

    public Double getFeedinenergy() {
        return feedinenergy;
    }

    public void setFeedinenergy(Double feedinenergy) {
        this.feedinenergy = feedinenergy;
    }

    public Double getConsumeenergy() {
        return consumeenergy;
    }

    public void setConsumeenergy(Double consumeenergy) {
        this.consumeenergy = consumeenergy;
    }

    public Double getFeedinpowerM2() {
        return feedinpowerM2;
    }

    public void setFeedinpowerM2(Double feedinpowerM2) {
        this.feedinpowerM2 = feedinpowerM2;
    }

    public Double getSoc() {
        return soc;
    }

    public void setSoc(Double soc) {
        this.soc = soc;
    }

    public Double getPeps1() {
        return peps1;
    }

    public void setPeps1(Double peps1) {
        this.peps1 = peps1;
    }

    public Double getPeps2() {
        return peps2;
    }

    public void setPeps2(Double peps2) {
        this.peps2 = peps2;
    }

    public Double getPeps3() {
        return peps3;
    }

    public void setPeps3(Double peps3) {
        this.peps3 = peps3;
    }

    public String getInverterType() {
        return inverterType;
    }

    public void setInverterType(String inverterType) {
        this.inverterType = inverterType;
    }

    public String getInverterStatus() {
        return inverterStatus;
    }

    public void setInverterStatus(String inverterStatus) {
        this.inverterStatus = inverterStatus;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Double getBatPower() {
        return batPower;
    }

    public void setBatPower(Double batPower) {
        this.batPower = batPower;
    }

    public Double getPowerdc1() {
        return powerdc1;
    }

    public void setPowerdc1(Double powerdc1) {
        this.powerdc1 = powerdc1;
    }

    public Double getPowerdc2() {
        return powerdc2;
    }

    public void setPowerdc2(Double powerdc2) {
        this.powerdc2 = powerdc2;
    }

    public Double getPowerdc3() {
        return powerdc3;
    }

    public void setPowerdc3(Double powerdc3) {
        this.powerdc3 = powerdc3;
    }

    public Double getPowerdc4() {
        return powerdc4;
    }

    public void setPowerdc4(Double powerdc4) {
        this.powerdc4 = powerdc4;
    }
}
