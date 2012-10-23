package prototipo.cuatro;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class Prototipo4Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btnPaco = (Button) findViewById(R.id.btnPaco);
        Button btnAmbu = (Button) findViewById(R.id.btnAmbu);
        Button btnBombe = (Button) findViewById(R.id.btnBombe);
        Button btnPDI = (Button) findViewById(R.id.btnPDI);
        
        btnPaco.setOnClickListener(new OnClickListener() {
        	public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		Intent i=new Intent(Intent.ACTION_CALL,Uri.parse("tel:56973777933"));
        	    startActivity(i);
        	}
    	});
        
        btnAmbu.setOnClickListener(new OnClickListener() {
        	public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		Intent i=new Intent(Intent.ACTION_CALL,Uri.parse("tel:56987321637"));
        	    startActivity(i);
        	}
    	});
        
        btnBombe.setOnClickListener(new OnClickListener() {
        	public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		Intent i=new Intent(Intent.ACTION_CALL,Uri.parse("tel:132"));
        	    startActivity(i);
        	}
    	});
        
        btnPDI.setOnClickListener(new OnClickListener() {
        	public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		Intent i=new Intent(Intent.ACTION_CALL,Uri.parse("tel:56273777933"));
        	    startActivity(i);
        	}
    	});

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        LocationManager milocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        LocationListener milocListener = new MiLocationListener();

        milocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, milocListener);
    }
    
    public class MiLocationListener implements LocationListener{

    	public void onLocationChanged(Location loc){
    		loc.getLatitude();
    		loc.getLongitude();
    		
    		String coordenadas = "Mis coordenadas son: "
    				+ "Latitud = " + loc.getLatitude()
    				+ "Longitud = " + loc.getLongitude();
    		
    		Toast.makeText( getApplicationContext(),coordenadas,Toast.LENGTH_LONG).show();
    	}
    
    	public void onProviderDisabled(String provider){
    		Toast.makeText( getApplicationContext(),"Gps Desactivado",Toast.LENGTH_SHORT ).show();
    	}
    	
    	public void onProviderEnabled(String provider){
    		Toast.makeText( getApplicationContext(),"Gps Activo",Toast.LENGTH_SHORT ).show();
    	}
    	
    	public void onStatusChanged(String provider, int status, Bundle extras){}
    	
    }
}