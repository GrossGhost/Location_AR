package com.markyhzhang.project.navar;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;

import java.util.concurrent.CompletableFuture;

import uk.co.appoly.arcorelocation.LocationMarker;

public class Waypoint {

    private String name;

    private CompletableFuture<ModelRenderable> layout;
    private ModelRenderable layoutRenderable;
    private double longitude, latitude;
    private String id;
    private boolean finishedLoading;

    private LocationMarker locationMarker;

    public Waypoint(String name, CompletableFuture<ModelRenderable> layout, double longitude, double latitude, String id){
        this.name = name;
        this.layout = layout;
        this.longitude = longitude;
        this.latitude = latitude;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean hasFinishedLoading() {
        return finishedLoading;
    }

    public void setFinishedLoading(boolean finishedLoading) {
        this.finishedLoading = finishedLoading;
    }

    public CompletableFuture<ModelRenderable> getLayout() {
        return layout;
    }

    public void setLayout(CompletableFuture<ModelRenderable> layout) {
        this.layout = layout;
    }

    public ModelRenderable getLayoutRenderable() {
        return layoutRenderable;
    }

    public void setLayoutRenderable(ModelRenderable layoutRenderable, Context context) {
        this.layoutRenderable = layoutRenderable;

        Node node = new Node();
        node.setRenderable(layoutRenderable);
        locationMarker = new LocationMarker(longitude, latitude, node);

//        locationMarker.setScalingMode(LocationMarker.ScalingMode.GRADUAL_TO_MAX_RENDER_DISTANCE);

//        locationMarker.setRenderEvent(node1 -> {
//            View eView = layoutRenderable.getView();
//            ((TextView)eView.findViewById(R.id.waypointTitle)).setText(name);
//
//            //TODO adjust units accordingly
//            ((TextView)eView.findViewById(R.id.waypointDistance)).setText(node1.getDistance() + " m");
//
//
//        });

        node.setOnTapListener((v, event) -> Toast.makeText(
                context, name, Toast.LENGTH_LONG)
                .show());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public LocationMarker getLocationMarker() {
        return locationMarker;
    }
}
