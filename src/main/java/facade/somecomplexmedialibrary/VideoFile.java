package facade.somecomplexmedialibrary;

public class VideoFile {

  private final String name;

  private final String codecType;

  public VideoFile(final String name) {
    this.name = name;
    this.codecType = name.substring(name.indexOf(".") + 1);
  }

  public String getName() {
    return this.name;
  }

  public String getCodecType() {
    return this.codecType;
  }
}
