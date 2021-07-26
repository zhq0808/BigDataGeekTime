package phoneData;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

class FloaData {
    private int phoneNum;//手机号
    private int upFlow;//手机上行流量
    private int downFlow; //手机下行流量

    public PhoneFlowCount(int phoneNum, int upFlow, int downFlow) {
        this.phoneNum = phoneNum;
        this.upFlow = upFlow;
        this.downFlow = downFlow;
    }

    public int getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getUpFlow() {
        return this.upFlow;
    }

    public void setUpFlow(int upFlow) {
        this.upFlow = upFlow;
    }

    public int getDownFlow() {
        return this.downFlow;
    }

    public void setDownFlow(int downFlow) {
        this.downFlow = downFlow;
    }
}