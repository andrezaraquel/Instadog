package picoledelimao.github.io.instadog;

/**
 * A interface used to communicate to the fragment that it must be refresh
 * @author Abner M. C. Araujo
 * @version 1.0
 * @since 01.17.2016
 */
public interface RefreshableFragment {

    /**
     * Refresh the content of a fragment
     */
    void refresh();

}
