package eu.decentsoftware.holograms.nms.v1_20_R4;

import eu.decentsoftware.holograms.nms.api.renderer.NmsSmallHeadHologramRenderer;

class SmallHeadHologramRenderer extends HeadHologramRenderer implements NmsSmallHeadHologramRenderer {

    SmallHeadHologramRenderer(EntityIdGenerator entityIdGenerator) {
        super(entityIdGenerator, true);
    }

}
