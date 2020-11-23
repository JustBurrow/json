package kr.lul.json.model;

import kr.lul.common.util.Anchor;

/**
 * @author justburrow
 * @since 2020/10/20
 */
public abstract class JsonModelAnchor extends Anchor {
  public static final Package PACKAGE = JsonModelAnchor.class.getPackage();
  public static final String PACKAGE_NAME = JsonModelAnchor.class.getPackageName();

  protected JsonModelAnchor() {
    throw new UnsupportedOperationException();
  }
}
