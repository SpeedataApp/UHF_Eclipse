package com.speedata.libuhf;


import android.os.Handler;

/**
 * Created by brxu on 2016/12/13.
 */

public interface IUHFService {

    public static final int REGION_CHINA_840_845 = 0;
    public static final int REGION_CHINA_920_925 = 1;
    public static final int REGION_CHINA_902_928 = 2;
    public static final int REGION_EURO_865_868 = 3;
    public static final int RESERVED_A = 0;
    public static final int EPC_A = 1;
    public static final int TID_A = 2;
    public static final int USER_A = 3;
    public static final int FAST_MODE = 0;
    public static final int SMART_MODE = 1;
    public static final int LOW_POWER_MODE = 2;
    public static final int USER_MODE = 3;
    public static final String SERIALPORT = "/dev/ttyMT2";
    public static final String POWERCTL = "/sys/class/misc/mtgpio/pin";

    //Ĭ�ϲ�����ʼ��ģ��
    public int OpenDev();

    //�ͷ�ģ��
    public void CloseDev();

    //��ʼ�̵�
    public void inventory_start();

    // Handler���ڴ����ص��̵�����
    public void inventory_start(Handler hd);
    //��������
    public int set_Password(int which, String cur_pass, String new_pass);
     //ֹͣ�̵�
    public void inventory_stop();

    /**
     * �ӱ�ǩ area ���� addr λ�ã��� word ���㣩��ȡ count ��ֵ���� byte ���㣩
     * passwd �Ƿ������룬�������û�����͸� 0 ֵ��
     *
     * @param area
     * @param addr
     * @param count
     * @param passwd
     * @return
     */
    public byte[] read_area(int area, int addr, int count, int passwd);
    public String read_area(int area, String str_addr
            , String str_count, String str_passwd);


    //�� content �е�����д����ǩ area ���� addr���� word ���㣩��ʼ��λ �á�
    public int write_area(int area, int addr, int passwd, byte[] content);
    public int write_area(int area, String addr, String pwd, String count, String content);


    //ѡ��Ҫ���в����� epc ��ǩ
    public int select_card(byte[] epc);
    public int select_card(String epc);


    //�������߹���
    public int set_antenna_power(int power);

    //��ȡ��ǰ���߹���ֵ
    public int get_antenna_power();

    //����Ƶ������
    public int set_freq_region(int region);

    public int get_freq_region();

    //�����̵��handler
    public void reg_handler(Handler hd);


    public INV_TIME get_inventory_time();
    public int set_inventory_time(int work_t, int rest_t);
    public int MakeSetValid();
    public int setlock(int type, int area, int passwd);
    public int get_inventory_mode();
    public int set_inventory_mode(int m);
}