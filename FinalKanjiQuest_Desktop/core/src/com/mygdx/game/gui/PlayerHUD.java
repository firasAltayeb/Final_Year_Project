package com.mygdx.game.gui;

/*
public class PlayerHUD implements Screen, ProfileObserver {
    private Stage stage;
    private Viewport viewport;
    private StatusUI statusUI;
    private InventoryUI inventoryUI;
    private Camera camera;
    private Entity player;

    public PlayerHUD(Camera camera, Entity player) {
        this.camera = camera;
        this.player = player;
        viewport = new ScreenViewport(this.camera);
        stage = new Stage(viewport);
        //stage.setDebugAll(true);

        statusUI = new StatusUI();
        statusUI.setVisible(true);
        statusUI.setPosition(0, 0);

        inventoryUI = new InventoryUI();
        inventoryUI.setMovable(false);
        inventoryUI.setVisible(false);
        inventoryUI.setPosition(stage.getWidth()/2, 0);

        stage.addActor(statusUI);
        stage.addActor(inventoryUI);

        //add tooltips to the stage
        Array<Actor> actors = inventoryUI.getInventoryActors();
        for(Actor actor : actors){
            stage.addActor(actor);
        }

        ImageButton inventoryButton = statusUI.getInventoryButton();
        inventoryButton.addListener(new ClickListener() {
            public void clicked (InputEvent event, float x, float y) {
                inventoryUI.setVisible(inventoryUI.isVisible()?false:true);
            }
        });
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void onNotify(ProfileManager profileManager, ProfileEvent event) {
        switch(event){
            case PROFILE_LOADED:
                Array<InventoryItemLocation> inventory = profileManager.getProperty("playerInventory", Array.class);
                if( inventory != null && inventory.size > 0 ){
                    inventoryUI.populateInventory(inventoryUI.getInventorySlotTable(), inventory);
                }else{
                    //add default items if nothing is found
                    Array<ItemTypeID> items = player.getEntityConfig().getInventory();
                    Array<InventoryItemLocation> itemLocations = new Array<InventoryItemLocation>();
                    for( int i = 0; i < items.size; i++){
                        itemLocations.add(new InventoryItemLocation(i, items.get(i).toString(), 1));
                    }
                    inventoryUI.populateInventory(inventoryUI.getInventorySlotTable(), itemLocations);
                }

                Array<InventoryItemLocation> equipInventory = profileManager.getProperty("playerEquipInventory", Array.class);
                if( equipInventory != null && equipInventory.size > 0 ){
                    inventoryUI.populateInventory(inventoryUI.getEquipSlotTable(), equipInventory);
                }

                break;
            case SAVING_PROFILE:
                profileManager.setProperty("playerInventory", inventoryUI.getInventory(inventoryUI.getInventorySlotTable()));
                profileManager.setProperty("playerEquipInventory", inventoryUI.getInventory(inventoryUI.getEquipSlotTable()));
                break;
            default:
                break;
        }
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
*/