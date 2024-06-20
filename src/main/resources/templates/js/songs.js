var songs = [
  {
    'pulse': ZeldaSynth1,
    'square': ZeldaSynth2,
    'triangle': ZeldaBass1,
    'noise': ZeldaBass2,
    'length': '39',
    'video': 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/355309/8-bit-zelda.mp4'
  },
  {
    'pulse': filterNotes(PacmanSynth1).notes,
    'square': null,
    'triangle': filterNotes(PacmanBass1).notes,
    'noise': null,
    'length': '2m',
    'video': 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/355309/8-bit-pacman.mp4'
  },
  {
    'pulse': MarioSynth1,
    'square': MarioSynth2,
    'triangle': MarioBass1,
    'noise': MarioBass2,
    'length': '85',
    'video': 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/355309/8-bit-mario.mp4'
  },
  {
    'pulse': MetroidSynth1,
    'square': MetroidSynth2,
    'triangle': null,
    'noise': null,
    'length': '102',
    'video': 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/355309/8-bit-metroid.mp4'
  },
  {
    'pulse': KirbySynth1,
    'square': KirbySynth2,
    'triangle': KirbyBass1,
    'noise': KirbyBass2,
    'length': '96',
    'video': 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/355309/8-bit-kirby.mp4'
  }
];