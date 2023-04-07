package com.example.bankdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AppCompatButton  btnCallS,btnVisitS,btnShareS; //SBI bank Id Define
    AppCompatButton btnCallB,btnVisitB,btnShareB;   //BOB bank Id Define
    AppCompatButton btnCallH,btnVisitH,btnShareH;  //HDFC bank Id Define
    AppCompatButton btnCallA,btnVisitA,btnShareA;  //AXIS bank Id Define
    AppCompatButton btnCallBI,btnVisitBI,btnShareBI;  //BOI bank Id Define
    AppCompatButton btnCallP,btnVisitP,btnShareP;    //PNG bank Id Define
    AppCompatButton btnCallY,btnVisitY,btnShareY;  //YAS bank Id Define
    AppCompatButton btnCallC,btnVisitC,btnShareC;  //CENTRAL bank Id Define
    AppCompatButton btnCallU,btnVisitU,btnShareU;  //UNION bank Id Define
    AppCompatButton btnCallI,btnVisitI,btnShareI;  //ICICI bank Id Define

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idDefine();

    }

    public void idDefine() {
    //SBI bank Id Button Define
        btnCallS=findViewById(R.id.btnCallS);
        btnVisitS =findViewById(R.id.btnVisitS);
        btnShareS=findViewById(R.id.btnShareS);

    //BOB bank Id Button Define
        btnCallB=findViewById(R.id.btnCallB);
        btnVisitB=findViewById(R.id.btnVisitB);
        btnShareB =findViewById(R.id.btnShareB);

    //HDFC bank Id Button Define
        btnCallH=findViewById(R.id.btnCallH);
        btnVisitH=findViewById(R.id.btnVisitH);
        btnShareH=findViewById(R.id.btnShareH);

    //AXIS bank Id Button Define
        btnCallA=findViewById(R.id.btnCallA);
        btnVisitA=findViewById(R.id.btnVisitA);
        btnShareA=findViewById(R.id.btnShareA);

    //BOI bank Id Button Define
        btnCallBI=findViewById(R.id.btnCallBI);
        btnVisitBI =findViewById(R.id.btnVisitBI);
        btnShareBI=findViewById(R.id.btnShareBI);

   //PNG bank Id Button Define
        btnCallP=findViewById(R.id.btnCallP);
        btnVisitP=findViewById(R.id.btnVisitP);
        btnShareP=findViewById(R.id.btnShareP);

    //YAS bank Id Button Define
        btnCallY=findViewById(R.id.btnCallY);
        btnVisitY=findViewById(R.id.btnVisitY);
        btnShareY =findViewById(R.id.btnShareY);

    //CENTRAL bank Id Button Define
        btnCallC=findViewById(R.id.btnCallC);
        btnVisitC=findViewById(R.id.btnVisitC);
        btnShareC =findViewById(R.id.btnShareC);


    //UNION bank Id Button Define
        btnCallU=findViewById(R.id.btnCallU);
        btnVisitU=findViewById(R.id.btnVisitU);
        btnShareU=findViewById(R.id.btnShareU);

    //ICICI bank Id Button Define
        btnCallI=findViewById(R.id.btnCallI);
        btnVisitI=findViewById(R.id.btnVisitI);
        btnShareI =findViewById(R.id.btnShareI);

        sbi();
        bob();
        hdfc();
        axis();
        boi();
        png();
        yas();
        cbi();
        union();
        icici();
    }

    public void sbi() {
        //Call Define
        btnCallS.setOnClickListener(b->{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1800 1234"));
            startActivity(intent);
        });

        //Visit Wab site define
        btnVisitS.setOnClickListener(v ->{
//            Intent browserIntent=new Intent(Intent.ACTION_VIEW);
//            browserIntent.setData(Uri.parse("https://www.onlinesbi.sbi"));
//            startActivity(browserIntent);
            Intent intent = new Intent(this, WabViewActivity.class);
            intent.putExtra("url", "https://www.onlinesbi.sbi");
            startActivity(intent);
        });

        //Shear Link
        btnShareS.setOnClickListener(s->{
            Intent ShareIntent=new Intent(Intent.ACTION_SEND);
            ShareIntent.setType("text/plain");
            ShareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.onlinesbi.sbi");
            startActivity(ShareIntent);
        });
    }

    public void bob() {
        //Call Define
        btnCallB.setOnClickListener(b->{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1800 102 4455"));
            startActivity(intent);
        });

        //Visit Wab site define
        btnVisitB.setOnClickListener(v ->{
//            Intent browserIntent=new Intent(Intent.ACTION_VIEW);
//            browserIntent.setData(Uri.parse("https://www.bankofbaroda.in"));
//            startActivity(browserIntent);
            Intent intent = new Intent(this, WabViewActivity.class);
            intent.putExtra("url", "https://www.bankofbaroda.in");
            startActivity(intent);
        });

        //Shear Link
        btnShareB.setOnClickListener(s->{
            Intent ShareIntent=new Intent(Intent.ACTION_SEND);
            ShareIntent.setType("text/plain");
            ShareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.bankofbaroda.in");
            startActivity(ShareIntent);
        });
    }

    public void hdfc() {
        //Call Define
        btnCallH.setOnClickListener(b->{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1800 202 6161"));
            startActivity(intent);
        });

        //Visit Wab site define
        btnVisitH.setOnClickListener(v ->{
//            Intent browserIntent=new Intent(Intent.ACTION_VIEW);
//            browserIntent.setData(Uri.parse("https://www.hdfcbank.com"));
//            startActivity(browserIntent);
            Intent intent = new Intent(this, WabViewActivity.class);
            intent.putExtra("url", "https://www.hdfcbank.com");
            startActivity(intent);
        });

        //Shear Link
        btnShareH.setOnClickListener(s->{
            Intent ShareIntent=new Intent(Intent.ACTION_SEND);
            ShareIntent.setType("text/plain");
            ShareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.hdfcbank.com");
            startActivity(ShareIntent);
        });
    }

    public void axis() {
        //Call Define
        btnCallA.setOnClickListener(b->{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1860 419 5555"));
            startActivity(intent);
        });

        //Visit Wab site define
        btnVisitA.setOnClickListener(v ->{
//            Intent browserIntent=new Intent(Intent.ACTION_VIEW);
//            browserIntent.setData(Uri.parse("https://www.axisbank.com"));
//            startActivity(browserIntent);
            Intent intent = new Intent(this, WabViewActivity.class);
            intent.putExtra("url", "https://www.axisbank.com");
            startActivity(intent);
        });

        //Shear Link
        btnShareA.setOnClickListener(s->{
            Intent ShareIntent=new Intent(Intent.ACTION_SEND);
            ShareIntent.setType("text/plain");
            ShareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.axisbank.com/");
            startActivity(ShareIntent);
        });
    }

    public void boi() {
        //Call Define
        btnCallBI.setOnClickListener(b->{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1800 103 1906"));
            startActivity(intent);
        });

        //Visit Wab site define
        btnVisitBI.setOnClickListener(v ->{
//            Intent browserIntent=new Intent(Intent.ACTION_VIEW);
//            browserIntent.setData(Uri.parse("https://www.bankofindia.co.in"));
//            startActivity(browserIntent);
            Intent intent = new Intent(this, WabViewActivity.class);
            intent.putExtra("url", "https://www.bankofindia.co.in");
            startActivity(intent);
        });

        //Shear Link
        btnShareBI.setOnClickListener(s->{
            Intent ShareIntent=new Intent(Intent.ACTION_SEND);
            ShareIntent.setType("text/plain");
            ShareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.bankofindia.co.in");
            startActivity(ShareIntent);
        });
    }

    public void png() {
        //Call Define
        btnCallP.setOnClickListener(b->{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1800 180 2222"));
            startActivity(intent);
        });

        //Visit Wab site define
        btnVisitP.setOnClickListener(v ->{
//            Intent browserIntent=new Intent(Intent.ACTION_VIEW);
//            browserIntent.setData(Uri.parse("https://www.pnbindia.in"));
//            startActivity(browserIntent);
            Intent intent = new Intent(this, WabViewActivity.class);
            intent.putExtra("url", "https://www.pnbindia.in");
            startActivity(intent);
        });

        //Shear Link
        btnShareP.setOnClickListener(s->{
            Intent ShareIntent=new Intent(Intent.ACTION_SEND);
            ShareIntent.setType("text/plain");
            ShareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.pnbindia.in");
            startActivity(ShareIntent);
        });
    }

    public void yas() {
        //Call Define
        btnCallY.setOnClickListener(b->{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1800 1200"));
            startActivity(intent);
        });

        //Visit Wab site define
        btnVisitY.setOnClickListener(v ->{
//            Intent browserIntent=new Intent(Intent.ACTION_VIEW);
//            browserIntent.setData(Uri.parse("https://www.yesbank.in"));
//            startActivity(browserIntent);
            Intent intent = new Intent(this, WabViewActivity.class);
            intent.putExtra("url", "https://www.yesbank.in");
            startActivity(intent);
        });

        //Shear Link
        btnShareY.setOnClickListener(s->{
            Intent ShareIntent=new Intent(Intent.ACTION_SEND);
            ShareIntent.setType("text/plain");
            ShareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.yesbank.in");
            startActivity(ShareIntent);
        });
    }

    public void cbi() {
        //Call Define
        btnCallC.setOnClickListener(b->{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1800 22 1911"));
            startActivity(intent);
        });

        //Visit Wab site define
        btnVisitC.setOnClickListener(v ->{
//            Intent browserIntent=new Intent(Intent.ACTION_VIEW);
//            browserIntent.setData(Uri.parse("https://www.centralbankofindia.co.in"));
//            startActivity(browserIntent);
            Intent intent = new Intent(this, WabViewActivity.class);
            intent.putExtra("url", "https://www.centralbankofindia.co.in");
            startActivity(intent);
        });

        //Shear Link
        btnShareC.setOnClickListener(s->{
            Intent ShareIntent=new Intent(Intent.ACTION_SEND);
            ShareIntent.setType("text/plain");
            ShareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.centralbankofindia.co.in");
            startActivity(ShareIntent);
        });
    }

    public void union() {
        //Call Define
        btnCallU.setOnClickListener(b->{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:1800 22 2244"));
            startActivity(intent);
        });

        //Visit Wab site define
        btnVisitU.setOnClickListener(v ->{
//            Intent browserIntent=new Intent(Intent.ACTION_VIEW);
//            browserIntent.setData(Uri.parse("https://www.unionbankofindia.co.in"));
//            startActivity(browserIntent);
            Intent intent = new Intent(this, WabViewActivity.class);
            intent.putExtra("url", "https://www.unionbankofindia.co.in");
            startActivity(intent);
        });

        //Shear Link
        btnShareU.setOnClickListener(s->{
            Intent ShareIntent=new Intent(Intent.ACTION_SEND);
            ShareIntent.setType("text/plain");
            ShareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.unionbankofindia.co.in");
            startActivity(ShareIntent);
        });
    }

    public void icici() {
        //Call Define
        btnCallI.setOnClickListener(b->{
            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel: 1800 1080"));
            startActivity(intent);
        });

        //Visit Wab site define
        btnVisitI.setOnClickListener(v ->{
//            Intent browserIntent=new Intent(Intent.ACTION_VIEW);
//            browserIntent.setData(Uri.parse("https://www.icicibank.com"));
//            startActivity(browserIntent);
            Intent intent = new Intent(this, WabViewActivity.class);
            intent.putExtra("url", "https://www.icicibank.com");
            startActivity(intent);
        });

        //Shear Link
        btnShareI.setOnClickListener(s->{
            Intent ShareIntent=new Intent(Intent.ACTION_SEND);
            ShareIntent.setType("text/plain");
            ShareIntent.putExtra(Intent.EXTRA_TEXT,"https://www.icicibank.com");
            startActivity(ShareIntent);
        });
    }
}