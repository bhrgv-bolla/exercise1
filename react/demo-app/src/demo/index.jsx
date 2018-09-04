import React from "react";


const styles = {
    outerDiv: {
        height: 500,
        width: 700,
        position: "relative",
    },
    img: {
        height: 500,
        width: 700,
        position: "absolute",
    },
    caption: {
        position: "absolute",
        bottom: "10%",
        left: "10%"
    },
    leftPress: {
        position: "absolute",
        width: "50%",
        height: "100%",
        backgroundColor: "orange",
        opacity: 0.3,
    },
    rightPress: {
        position: "absolute",
        width: "50%",
        left: "50%",
        height: "100%",
        backgroundColor: "green",
        opacity: 0.3,
    }
};

/**
 * The PhotoGallery component should take in an array of images.
 • Each image will have a url and a caption.
 • The captions should be displayed over the image.
 • The PhotoGallery should allow users to either click or swipe through the images.
 • Bonus credit for smoothly animating the swipe and transition between images.
 • Handle any edge cases you can think of.
 */
export default class PhotoGallery extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            currentIdx: 0
        };
        this.handleLeftPress = this.handleLeftPress.bind(this);
        this.handleRightPress = this.handleRightPress.bind(this);
    }

    handleLeftPress() {
        if (this.state.currentIdx === 0) return;
        this.setState({
            currentIdx: this.state.currentIdx - 1
        });
    }

    handleRightPress() {
        if (this.state.currentIdx === this.props.data.length - 1) return;
        this.setState({
            currentIdx: this.state.currentIdx + 1
        });
    }


    render() {
        const {data} = this.props;
        const {currentIdx} = this.state;
        return (
            <div style={styles.outerDiv}>
                <img src={data[currentIdx].url} style={styles.img}/>

                <span style={styles.caption}>
                  {data[currentIdx].caption}
              </span>

                <span style={styles.leftPress} onClick={this.handleLeftPress}></span>
                <span style={styles.rightPress} onClick={this.handleRightPress}></span>
            </div>
        );
    }


}